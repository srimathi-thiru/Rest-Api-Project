package com.springboot.languagelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.repository.CourseRepository;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

   
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }

    public List<Course> createMultipleCourses(List<Course> courses) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createMultipleCourses'");
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
    }

    public void deleteCourse(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }

    public Page<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable); 
    }
}
