package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.User;
import com.springboot.languagelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/getAll")
    public Page<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("desc") 
                    ? Sort.by(sortField).descending() 
                    : Sort.by(sortField).ascending();
                    
        Pageable pageable = PageRequest.of(page, size, sort);
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/existsByEmail")
    public boolean checkIfEmailExists(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

}
