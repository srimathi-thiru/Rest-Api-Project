package com.springboot.languagelearning.repository;

//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.entities.Language;
import com.springboot.languagelearning.entities.Course.DifficultyLevel;


public interface CourseRepository extends JpaRepository<Course, Long> {
    // List<Course> findByLanguage(Language language);
    // List<Course> findByDifficultyLevel(DifficultyLevel difficultyLevel);


    Page<Course> findByLanguage(Language language, Pageable pageable);

    Page<Course> findByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable);

                    



}
