package com.springboot.languagelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.entities.Course.DifficultyLevel;
import com.springboot.languagelearning.entities.Language;
import com.springboot.languagelearning.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
        
    
        public Course createCourse(Course course) {
            return courseRepository.save(course);
        }
    
        public Page<Course> getAllCourses(Pageable pageable) {
            return courseRepository.findAll(pageable);
        }
    
        public Page<Course> getCoursesByLanguage(Language language, Pageable pageable) {
            return courseRepository.findByLanguage(language, pageable);
        }
    
        public Page<Course> getCoursesByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable) {
            return courseRepository.findByDifficultyLevel(difficultyLevel, pageable);
        }
    
        public Course getCourseById(Long id) {
            return courseRepository.findById(id).orElse(null);
        }
    
        

}
