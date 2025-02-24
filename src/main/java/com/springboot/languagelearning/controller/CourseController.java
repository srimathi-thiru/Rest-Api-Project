package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    
    @SuppressWarnings("unchecked")
    @GetMapping("/getAll")
    public Page<Course> getAllCourses(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Pageable pageable = PageRequest.of(page, size, 
                          sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        return (Page<Course>) courseService.getAllCourses(pageable);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully.";
    }
}
