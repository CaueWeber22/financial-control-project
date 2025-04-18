package com.fcproject.controllers;

import com.fcproject.data.mapper.ObjectMapper;
import com.fcproject.data.models.UserEntity;
import com.fcproject.exception.NotAllFieldsFilledException;
import com.fcproject.exception.UserAlreadyExistsException;
import com.fcproject.data.dto.userDTO.UserDTO;
import com.fcproject.data.dto.userDTO.UserPostDTO;
import com.fcproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServices userServices;

    // POST to create users
    @PostMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<String> createUser(@RequestBody UserPostDTO user) {
        //Check if the fields are empty
        if ((user.getEmail().isBlank() || user.getEmail().isEmpty()) || (user.getPassword().isBlank() || user.getPassword().isEmpty()) || (user.getFirstName().isBlank() || user.getFirstName().isEmpty()) || (user.getLastName().isBlank() || user.getLastName().isEmpty())) {
            throw new NotAllFieldsFilledException("All fields must be filled");
        } else {
            UserDTO userGet = userServices.getUserByEmail(user.getEmail());
            if (userGet != null) {
                throw new UserAlreadyExistsException("An user with this e-mail already exists");
            }

            return userServices.createUser(ObjectMapper.parseObject(user, UserEntity.class));
        }
    }

    // GET to search users by email
    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
        // Calling the user search by email function
        UserDTO user = userServices.getUserByEmail(email);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GET to search users by id
    @GetMapping(
            value = "{user_id}/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer user_id) {

        UserDTO user = userServices.getUserById(user_id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //User delete
    @DeleteMapping("{user_id}/")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") Integer user_id) {
        UserDTO user = userServices.getUserById(user_id);

        if (user != null) {
            userServices.deleteUser(user_id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
