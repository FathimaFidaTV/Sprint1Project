package com.example.BookYourGroceryHere.Controller;


import com.example.BookYourGroceryHere.Model.User;
import com.example.BookYourGroceryHere.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Optional<User> existingUser = userService.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return "Username already exists!";
        }

        userService.save(user);
        return "Registration successful!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        Optional<User> user = userService.findByUserId(userId);
        if (user.isPresent()) {
            userService.delete(userId);
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }
}

