//package com.fcproject.services;
//
//import com.fcproject.TestsMocks.UserMocks;
//import com.fcproject.data.dto.userDTO.UserDTO;
//
//import com.fcproject.data.models.Gender;
//import com.fcproject.data.models.UserEntity;
//import com.fcproject.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.ArgumentCaptor;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//import static org.mockito.ArgumentMatchers.anyInt;
//import java.time.LocalDate;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)
//class UserServicesTest {
//
//    UserMocks input;
//
//    @InjectMocks
//    private UserServices userServices;
//
//    @Mock
//    UserRepository userRepository;
//
//
//    @BeforeEach
//    void setUp() {
//        input = new UserMocks();
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetUserByEmail() {
//        Integer id = 1;
//        UserEntity userEntityMock = input.mockUserEntity(id); // User mocked for test
//        when(userRepository.findByEmail("test@email.com" + id)).thenReturn(Optional.of(userEntityMock));
//
//        UserDTO result = userServices.getUserByEmail("test@email.com" +id);
//
//        //Asserts
//        assertNotNull(result);
//        assertEquals("test@email.com"+id, result.getEmail());
//        assertEquals("LastName"+id, result.getLastName());
//        assertEquals("Name"+id, result.getFirstName());
//        assertEquals("+5511999999999", result.getPhone());
//        assertEquals(LocalDate.parse("1900-05-05"), result.getBirthDay());
//        assertEquals(Gender.MALE, result.getGender());
//    }
//
//    @Test
//    void getUserById() {
//        Integer id = 2;
//        UserEntity userEntityMock = input.mockUserEntity(id); // User mocked for test
//        when(userRepository.findById(id)).thenReturn(Optional.of(userEntityMock));
//
//        UserDTO result = userServices.getUserById(id);
//
//        //Asserts
//        assertNotNull(result);
//        assertEquals("test@email.com"+id, result.getEmail());
//        assertEquals("LastName"+id, result.getLastName());
//        assertEquals("Name"+id, result.getFirstName());
//        assertEquals("+5511999999999", result.getPhone());
//        assertEquals(LocalDate.parse("1900-05-05"), result.getBirthDay());
//        assertEquals(Gender.MALE, result.getGender());
//    }
//
//    @Test
//    void createUser() {
//        Integer id = 1;
//        UserEntity userEntityMock = input.mockUserEntity(id); // User mocked for test
//        userEntityMock.setEmail("postEmail@email.com");
//        UserEntity userPersisted = userEntityMock;
//
//        when(userRepository.save(userEntityMock)).thenReturn(userPersisted);
//
//        //Calling user creation function
//       userServices.createUser(userEntityMock);
//
//        // Capturing the user created
//        ArgumentCaptor<UserEntity> userCaptor = ArgumentCaptor.forClass(UserEntity.class);
//        verify(userRepository).save(userCaptor.capture());
//        UserEntity capturedUser = userCaptor.getValue();
//
//
//        //Asserts
//        assertEquals("LastName"+id, capturedUser.getLastName());
//        assertEquals("Name"+id, capturedUser.getFirstName());
//        assertEquals("+5511999999999", capturedUser.getPhone());
//        assertEquals(LocalDate.parse("1900-05-05"), capturedUser.getBirthDay());
//        assertEquals(Gender.MALE, capturedUser.getGender());
//    }
//
//    @Test
//    void deleteUser() {
//        Integer id = 2;
//        UserEntity user = input.mockUserEntity(id);
//        when(userRepository.findById(id)).thenReturn(Optional.of(user));
//
//        userServices.deleteUser(id);
//
//        verify(userRepository, times(1)).findById(anyInt());
//
//    }
//}