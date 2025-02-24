package com.fcproject.controllers;

import com.fcproject.exception.ResourceNotFound;
import com.fcproject.models.UserEntity;
import com.fcproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {

        if (user.getEmail() == null || user.getPassword() == null || user.getFirstName() == null || user.getLastName() == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            return userServices.createUser(user);
        }
    }

    @GetMapping
    public ResponseEntity<UserEntity> getUserByEmail(@RequestParam String email) {
        // Calling the user search by email function
        UserEntity user = userServices.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK); // Return the user and status 200
    }

}
