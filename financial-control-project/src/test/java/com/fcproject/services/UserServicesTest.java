package com.fcproject.services;

import com.fcproject.TestsMocks.UserMocks;
import com.fcproject.data.dto.userDTO.UserDTO;
import com.fcproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    UserMocks input;

    @InjectMocks
    private UserServices userServices;

    @Mock
    UserRepository userRepository;


    @BeforeEach
    void setUp() {
        input = new UserMocks();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }
}