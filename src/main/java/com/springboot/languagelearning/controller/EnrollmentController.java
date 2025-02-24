package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.Enrollment;
import com.springboot.languagelearning.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/add")
    public Enrollment enrollUser(@RequestParam Long userId, @RequestParam Long courseId) {
        return enrollmentService.enrollUser(userId, courseId);
    }

    @GetMapping("/getAll")
    public Page<Enrollment> getAllEnrollments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("desc") 
                    ? Sort.by(sortField).descending() 
                    : Sort.by(sortField).ascending();
                    
        Pageable pageable = PageRequest.of(page, size, sort);
        return enrollmentService.getAllEnrollments(pageable);
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PutMapping("/{id}/progress")
    public Enrollment updateProgress(@PathVariable Long id, @RequestParam double newProgress) {
        return enrollmentService.updateProgress(id, newProgress);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        return enrollmentService.deleteEnrollment(id);
    }
}
