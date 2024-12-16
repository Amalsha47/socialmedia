package com.example.socialmedia.controller;

import com.example.socialmedia.model.LoginRequest;
import com.example.socialmedia.model.User;
import com.example.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Sign up user
    @PostMapping("/signup")
    public User signUpUser(@RequestBody User user) {
        return userService.signUpUser(user);
    }

    // Login
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        if (userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            return "Login succussfull";
        }
        else {
            throw new IllegalArgumentException("Invalied username or password");
        }
    }

}

