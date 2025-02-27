package com.springboot.languagelearning.service;

import com.springboot.languagelearning.entities.User;
import com.springboot.languagelearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPreferredLanguage(userDetails.getPreferredLanguage());
            user.setProfilePicture(userDetails.getProfilePicture());
            user.setEnrolledCourses(userDetails.getEnrolledCourses());
            return userRepo.save(user);
        }
        return null;
    }

    public String deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }

    public Page<User> getAllUsers(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepo.findAll(pageable);
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

}
