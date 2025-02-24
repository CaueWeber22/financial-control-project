package com.fcproject.services;

import com.fcproject.exception.ResourceNotFound;
import com.fcproject.models.UserEntity;
import com.fcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.logging.Logger;

@Service
public class UserServices {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserByEmail(String email) {
        logger.info("Searching user by email" + email);

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound("User Not Found"));
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

}
