package com.fcproject.controllers;

import com.fcproject.exception.UserAlreadyExistsException;
import com.fcproject.models.UserEntity;
import com.fcproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServices userServices;

    // POST to create users
    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {

        if (user.getEmail() == null || user.getPassword() == null || user.getFirstName() == null || user.getLastName() == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            UserEntity userGet = userServices.getUserByEmail(user.getEmail());
            if (userGet != null) {
                throw new UserAlreadyExistsException("An user with this e-mail already exists");
            }
            return userServices.createUser(user);
        }
    }

    // GET to search users by email
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserEntity> getUserByEmail(@RequestParam String email) {
        // Calling the user search by email function
        UserEntity user = userServices.getUserByEmail(email);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GET to search users by id
    @GetMapping(
            value = "{user_id}/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer user_id) {

        Optional<UserEntity> user = userServices.getUserById(user_id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //User delete
    @DeleteMapping("{user_id}/")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") Integer user_id) {
        Optional<UserEntity> user = userServices.getUserById(user_id);

        if (user.isPresent()) {
            userServices.deleteUser(user_id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
