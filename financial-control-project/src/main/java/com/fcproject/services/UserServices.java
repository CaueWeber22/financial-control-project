package com.fcproject.services;

import com.fcproject.exception.ResourceNotFound;
import com.fcproject.models.UserEntity;
import com.fcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
