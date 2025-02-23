// package com.springboot.languagelearning.controller;

// import com.springboot.languagelearning.entities.User;
// import com.springboot.languagelearning.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("api/users")
// public class UserController {
//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public ResponseEntity<User> registerUser(@RequestBody User user) {
//         User registeredUser = userService.registerUser(user);
//         return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//     }

//     @GetMapping("/getAllUsers")
//     public ResponseEntity<Page<User>> getAllUsers(
//         @RequestParam(defaultValue = "0") int page,
//         @RequestParam(defaultValue = "10") int size,
//         @RequestParam(defaultValue = "id") String sortBy,
//         @RequestParam(defaultValue = "asc") String sortDirection
//     ) {
//         Pageable pageable = PageRequest.of(
//             page, size,
//             sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
//         );
//         Page<User> users = userService.getAllUsers(pageable);
//         return ResponseEntity.ok(users);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         User user = userService.getUserById(id);
//         return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//         User updatedUser = userService.updateUser(id, userDetails);
//         return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//         boolean isDeleted = userService.deleteUser(id);
//         return isDeleted ? new ResponseEntity<>("User deleted successfully", HttpStatus.OK)
//                          : new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//     }
// }


package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.User;
import com.springboot.languagelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "0") int size) {
        return userService.getAllUsers(page, size);
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
}
