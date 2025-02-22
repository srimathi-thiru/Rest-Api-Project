package com.springboot.languagelearning.repository;

import com.springboot.languagelearning.entities.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Page<Enrollment> findByUserId(Long userId, Pageable pageable);

    Page<Enrollment> findByCourseId(Long courseId, Pageable pageable);

    Enrollment findByUserIdAndCourseId(Long userId, Long courseId);

     @Query("SELECT e FROM Enrollment e WHERE e.course.id = :courseId")
    List<Enrollment> findEnrollmentsByCourseId(@Param("courseId") Long courseId);
    
                                        
}
