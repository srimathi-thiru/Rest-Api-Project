// package com.springboot.languagelearning.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import com.springboot.languagelearning.entities.Course;
// import com.springboot.languagelearning.entities.Course.DifficultyLevel;
// import com.springboot.languagelearning.entities.Language;
// import com.springboot.languagelearning.repository.CourseRepository;

// @Service
// public class CourseService {

//     @Autowired
//     private CourseRepository courseRepository;
        
    
//         public Course createCourse(Course course) {
//             return courseRepository.save(course);
//         }
    
//         public Page<Course> getAllCourses() {
//             return courseRepository.findAll(pageable);
//         }
    
//         public Page<Course> getCoursesByLanguage(Language language, Pageable pageable) {
//             return courseRepository.findByLanguage(language, pageable);
//         }
    
//         public Page<Course> getCoursesByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable) {
//             return courseRepository.findByDifficultyLevel(difficultyLevel, pageable);
//         }
    
//         public Course getCourseById(Long id) {
//             return courseRepository.findById(id).orElse(null);
//         }
    
        

// }


package com.springboot.languagelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> createMultipleCourses(List<Course> courses) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMultipleCourses'");
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
    }

    public void deleteCourse(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }
}
