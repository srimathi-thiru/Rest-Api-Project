package com.springboot.languagelearning.service;

import com.springboot.languagelearning.entities.Enrollment;
import com.springboot.languagelearning.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment(double progressPercentage, LocalDate enrollmentDate) {
        Enrollment enrollment = new Enrollment();
        enrollment.setProgressPercentage(progressPercentage);
        enrollment.setEnrollmentDate(enrollmentDate);
        return enrollmentRepository.save(enrollment);
    }

    public Page<Enrollment> getAllEnrollments(Pageable pageable) {
        return enrollmentRepository.findAll(pageable);
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

    public String deleteEnrollment(Long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return "Enrollment deleted successfully";
        }
        return "Enrollment not deleted";
    }
}
