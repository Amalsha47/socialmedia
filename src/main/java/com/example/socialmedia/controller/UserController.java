package com.example.socialmedia.controller;

import com.example.socialmedia.model.LoginRequest;
import com.example.socialmedia.service.ResponseObjectService;
import com.example.socialmedia.service.ResponseObjectiveService;
import com.example.socialmedia.model.User;

import com.example.socialmedia.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseObjectiveService> findAllUsers() {
        return new ResponseEntity<ResponseObjectiveService>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/profile")
    public ResponseEntity<ResponseObjectiveService> findById(@RequestBody User inputId) {
        return new ResponseEntity<ResponseObjectiveService>(userService.findById(inputId.getId()), HttpStatus.OK);
    }

    @PostMapping("/users/save")
    public ResponseEntity<ResponseObjectiveService> saveUser(@RequestBody User inputUser) {
        return new ResponseEntity<ResponseObjectiveService>(userService.saveUser(inputUser), HttpStatus.OK);
    }

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
        } else {
            throw new IllegalArgumentException("Invalied username or password");
        }
    }

    @PutMapping("/users/update")
    public ResponseEntity<ResponseObjectService> update(@RequestBody User inputUser) {
        return new ResponseEntity<ResponseObjectService>(userService.update(inputUser), HttpStatus.OK);
    }

    @GetMapping("/getdata")
    public ResponseEntity<String> testAfterLogin(Principal p) {
        return ResponseEntity.ok("Welcome. You are: " + p.getName());
    }
}
