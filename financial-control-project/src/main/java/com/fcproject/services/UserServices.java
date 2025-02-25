package com.fcproject.services;

import com.fcproject.models.UserEntity;
import com.fcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServices {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    private UserRepository userRepository;

    //GET user by email func
    public UserEntity getUserByEmail(String email) {
        logger.info("Searching user by email" + email);

        return userRepository.findByEmail(email);

    }

    //GET user by id func
    public Optional<UserEntity> getUserById(Integer user_id) {
        logger.info("Searching user by id" + user_id);

        return userRepository.findById(user_id);

    }

    //User creation
    public ResponseEntity<String> createUser(UserEntity user) {

        //Checking if the user's email is not null
        if ((user.getEmail() != null && !user.getEmail().isEmpty())) {
            userRepository.save(user);

            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User creation failed", HttpStatus.BAD_REQUEST);
        }
    }

    // User delete by id
    public void deleteUser(Integer user_id) {
        logger.info("Deleting user by id" + user_id);

        userRepository.deleteById(user_id);
    }


}
