package com.example.socialmedia.service;

import com.example.socialmedia.model.User;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {

<<<<<<< HEAD
=======

>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

<<<<<<< HEAD
    public ResponseObjectiveService findAll() {
        ResponseObjectiveService responseObj = new ResponseObjectiveService();
        responseObj.setPayload(userRepository.findAll());
        responseObj.setStatus("success");
        responseObj.setMessage("success");
        return responseObj;
    }

    public ResponseObjectiveService findById(String id) {
        ResponseObjectiveService responseObj = new ResponseObjectiveService();
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            responseObj.setStatus("fail");
            responseObj.setMessage("user id: " + id + " not existed");
            responseObj.setPayload(null);
            return responseObj;
        } else {
            responseObj.setPayload(optUser.get());
            responseObj.setStatus("success");
            responseObj.setMessage("success");
            return responseObj;
        }
    }

    public ResponseObjectiveService saveUser(User inputUser) {
        ResponseObjectiveService responseObj = new ResponseObjectiveService();
        Optional<User> optUser = userRepository.findByEmail(inputUser.getEmail());
        if (optUser.isPresent()) {
            responseObj.setStatus("fail");
            responseObj.setMessage("Email address " + inputUser.getEmail() + " existed");
            responseObj.setPayload(null);
            return responseObj;
        } else {
            inputUser.setPassword(passwordEncoder.encode(inputUser.getPassword()));

            // user follows himself so he could get his posts in newsfeed as well
            User user = userRepository.save(inputUser);
            responseObj.setPayload(user);
            responseObj.setStatus("success");
            responseObj.setMessage("success");
            return responseObj;
        }
    }

=======
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
    // Register new user
    public User signUpUser(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // encode password
        return userRepository.save(user);
    }

    // Authenticate user
<<<<<<< HEAD
    public boolean authenticateUser(String username, String password) {
=======
    public boolean authenticateUser(String username, String password){
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

<<<<<<< HEAD
    public ResponseObjectiveService update(User inputUser) {
        ResponseObjectiveService responseObj = new ResponseObjectiveService();
        Optional<User> optUser = userRepository.findById(inputUser.getId());
        if (optUser.isEmpty()) {
            responseObj.setStatus("fail");
            responseObj.setMessage("user id: " + inputUser.getId() + " not existed");
            responseObj.setPayload(null);
            return responseObj;
        } else {
            User currentUser = optUser.get();
            if (passwordEncoder.matches(inputUser.getPassword(), currentUser.getPassword())) {
                inputUser.setPassword(passwordEncoder.encode(inputUser.getPassword()));
                responseObj.setPayload(userRepository.save(inputUser));
                responseObj.setStatus("success");
                responseObj.setMessage("success");
                return responseObj;
            } else {
                responseObj.setStatus("fail");
                responseObj.setMessage("current password is not correct");
                responseObj.setPayload(null);
                return responseObj;
            }
        }

    }
=======
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
}
