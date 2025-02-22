package com.springboot.languagelearning.service;

import com.springboot.languagelearning.entities.Enrollment;
import com.springboot.languagelearning.entities.User;
import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.repository.EnrollmentRepository;
import com.springboot.languagelearning.repository.UserRepository;
import com.springboot.languagelearning.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollUser(Long userId, Long courseId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (userOpt.isPresent() && courseOpt.isPresent()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setUser(userOpt.get());
            enrollment.setCourse(courseOpt.get());
            enrollment.setProgressPercentage(0.0);
            enrollment.setEnrollmentDate(LocalDate.now());

            return enrollmentRepository.save(enrollment);
        } else {
            throw new RuntimeException("User or Course not found!");
        }
    }

    public Page<Enrollment> getAllEnrollments(Pageable pageable) {
        return enrollmentRepository.findAll(pageable);
    }

    public Page<Enrollment> getEnrollmentsByUserId(Long userId, Pageable pageable) {
        return enrollmentRepository.findByUserId(userId, pageable);
    }

    public Page<Enrollment> getEnrollmentsByCourseId(Long courseId, Pageable pageable) {
        return enrollmentRepository.findByCourseId(courseId, pageable);
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found!"));
    }

    public Enrollment updateProgress(Long enrollmentId, double newProgress) {
        Optional<Enrollment> enrollmentOpt = enrollmentRepository.findById(enrollmentId);

        if (enrollmentOpt.isPresent()) {
            Enrollment enrollment = enrollmentOpt.get();
            enrollment.setProgressPercentage(newProgress);
            return enrollmentRepository.save(enrollment);
        } else {
            throw new RuntimeException("Enrollment not found!");
        }
    }

    public boolean deleteEnrollment(Long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findEnrollmentsByCourseId(courseId);
    }
    
}
