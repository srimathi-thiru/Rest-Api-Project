package com.springboot.languagelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.languagelearning.entities.Registration;
import com.springboot.languagelearning.entities.User;
import com.springboot.languagelearning.service.RegistrationService;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/add")
    public Registration createRegistration(@RequestBody Registration registration) {
        return service.saveRegistration(registration);
    }

    @GetMapping("/getAll")
    public List<Registration> getAllRegistrations() {
        return service.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Long id) {
        return service.getRegistrationById(id);
    }

    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        registration.setId(id);
        return service.saveRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        service.deleteRegistration(id);
        return "Registration deleted successfully";
    }

   
    @GetMapping("/user/{userId}")
    public List<Registration> getRegistrationsByUser(@PathVariable Long userId) {
        return service.getRegistrationsByUser(userId);
    }

    @GetMapping("/course/{course}")
    public List<Registration> getRegistrationsByCourse(@PathVariable String course) {
        return service.getRegistrationsByCourse(course);
    }

    @GetMapping("/count/{course}")
    public long countRegistrationsByCourse(@PathVariable String course) {
        return service.countRegistrationsByCourse(course);
    }
}