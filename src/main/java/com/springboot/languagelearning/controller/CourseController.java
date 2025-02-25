package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.Course;
import com.springboot.languagelearning.service.CourseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    
    
    @GetMapping("/getAllcourses")
    public ResponseEntity<Page<Course>> getAllCoursesWithParams(
        @RequestParam int page, 
        @RequestParam int size, 
        @RequestParam String sort, 
        @RequestParam String order){
        Pageable pageable = PageRequest.of(page, size, 
                          order.equalsIgnoreCase("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending());
        return ResponseEntity.ok( courseService.getAllCourses(pageable));
    }

    
    @GetMapping("/getAll")
    public Page<Course> getAllCourses(Pageable pageable) {
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
