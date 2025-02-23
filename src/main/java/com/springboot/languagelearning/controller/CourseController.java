// package com.springboot.languagelearning.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.web.bind.annotation.*;

// import com.springboot.languagelearning.entities.Course;
// import com.springboot.languagelearning.entities.Course.DifficultyLevel;
// import com.springboot.languagelearning.entities.Language;
// import com.springboot.languagelearning.service.CourseService;

// @RestController
// @RequestMapping("/courses")
// public class CourseController {

//     @Autowired
//     private CourseService courseService;

//     @PostMapping("/createCourse")
//     public Course createCourse(@RequestBody Course course) {
//         return courseService.createCourse(course);
//     }

//     @GetMapping("/getCourse")
//     public Page<Course> getAllCourses(
//         @RequestParam(defaultValue = "0") int page,
//         @RequestParam(defaultValue = "10") int size,
//         @RequestParam(defaultValue = "id") String sortBy,
//         @RequestParam(defaultValue = "asc") String sortDirection
//     ) {
//         Pageable pageable = PageRequest.of(page, size, 
//                           sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//         return courseService.getAllCourses(pageable);
//     }

//     @GetMapping("/language/{languageId}")
//     public Page<Course> getCoursesByLanguage(
//         @PathVariable Long languageId,
//         @RequestParam(defaultValue = "0") int page,
//         @RequestParam(defaultValue = "10") int size,
//         @RequestParam(defaultValue = "id") String sortBy,
//         @RequestParam(defaultValue = "asc") String sortDirection
//     ) {
//         Language language = new Language();
//         language.setId(languageId);
//         Pageable pageable = PageRequest.of(page, size, 
//                           sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//         return courseService.getCoursesByLanguage(language, pageable);
//     }

//     @GetMapping("/difficulty/{difficulty}")
//     public Page<Course> getCoursesByDifficultyLevel(
//         @PathVariable DifficultyLevel difficulty,
//         @RequestParam(defaultValue = "0") int page,
//         @RequestParam(defaultValue = "10") int size,
//         @RequestParam(defaultValue = "id") String sortBy,
//         @RequestParam(defaultValue = "asc") String sortDirection
//     ) {
//         Pageable pageable = PageRequest.of(page, size, 
//                           sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//         return courseService.getCoursesByDifficultyLevel(difficulty, pageable);
//     }

//     @GetMapping("/{id}")
//     public Course getCourseById(@PathVariable Long id) {
//         return courseService.getCourseById(id);
//     }
     
// }

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

    @PostMapping("/addMultiple")
    public List<Course> createMultipleCourses(@RequestBody List<Course> courses) {
        return courseService.createMultipleCourses(courses);
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
