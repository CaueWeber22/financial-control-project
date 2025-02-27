package com.fcproject.services;

import com.fcproject.data.dto.UserDTO;
import com.fcproject.data.mapper.ObjectMapper;
import com.fcproject.data.models.UserEntity;
import com.fcproject.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class UserServices {

    private Logger logger = LoggerFactory.getLogger(UserServices.class.getName());

    @Autowired
    private UserRepository userRepository;

    //GET user by email func
    public UserDTO getUserByEmail(String email) {
        logger.info("Searching user by email " + email);

        return  userRepository.findByEmail(email)
                .map (user -> ObjectMapper.parseObject((user), UserDTO.class))
                .orElse(null);
    }

    //GET user by id func
    public UserDTO getUserById(Integer user_id) {
        logger.info("Searching user by id " + user_id);

        return userRepository.findById(user_id)
                .map(user -> ObjectMapper.parseObject(user, UserDTO.class))
                .orElse(null);
    }

    //User creation
    public ResponseEntity<String> createUser(UserEntity user) {
        logger.info("Creating with the email " + user.getEmail());

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
        logger.info("Deleting user by id " + user_id);
        userRepository.deleteById(user_id);
    }


}
