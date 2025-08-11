package com.fcproject.services;

import com.fcproject.data.dto.userDTO.UserDTO;
import com.fcproject.data.mapper.ObjectMapper;
import com.fcproject.data.models.UserEntity;
import com.fcproject.exception.NotAllFieldsFilledException;
import com.fcproject.exception.UserAlreadyExistsException;
import com.fcproject.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class UserServices {

    private final Logger logger = LoggerFactory.getLogger(UserServices.class.getName());

    @Autowired
    private UserRepository userRepository;

    //GET user by email func
    public UserDTO getUserByEmail(String email) {
        logger.info("Searching user by email {}", email);

        return userRepository.findByEmail(email)
                .map(user -> ObjectMapper.parseObject((user), UserDTO.class))
                .orElse(null);

    }

    //GET user by id func
    public UserDTO getUserById(Integer user_id) {
        logger.info("Searching user by id {}", user_id);

        return userRepository.findById(user_id)
                .map(user -> ObjectMapper.parseObject(user, UserDTO.class))
                .orElse(null);
    }

    //User creation
    public void createUser(UserEntity user) {
        logger.info("Creating user with the email {}", user.getEmail());


        if ((user.getEmail().isBlank() || user.getEmail().isEmpty()) ||
                (user.getPassword().isBlank() || user.getPassword().isEmpty()) ||
                (user.getFirstName().isBlank() || user.getFirstName().isEmpty()) ||
                (user.getLastName().isBlank() || user.getLastName().isEmpty())) {
            throw new NotAllFieldsFilledException("All fields must be filled");
        }

        if (getUserByEmail(user.getEmail()) != null) {
                throw new UserAlreadyExistsException("An user with this e-mail already exists");
        }

        userRepository.save(user);

    }

    // User delete by id
    public void deleteUser(Integer user_id) {
        logger.info("Deleting user by id {}", user_id);

        userRepository.deleteById(user_id);
    }


}
