package com.fcproject.TestsMocks;

import com.fcproject.data.dto.userDTO.UserDTO;
import com.fcproject.data.dto.userDTO.UserPostDTO;
import com.fcproject.data.models.Gender;
import com.fcproject.data.models.UserEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMocks {

    //User Entity for tests
    public UserEntity mockUserEntity(Integer id) {
        UserEntity user = new UserEntity();

        user.setId(id);
        user.setFirstName("Name" + id);
        user.setLastName("LastName" + id);
        user.setEmail("test@email.com" + id);
        user.setPhone("+5511999999999");
        user.setGender(Gender.MALE);
        user.setBirthDay(LocalDate.parse("1900-05-05"));

        return user;
    }

    //UserDTO (used in GET endpoints) for tests
    public UserDTO mockUserDTO(Integer id) {
        UserDTO user = new UserDTO();

        user.setId(id);
        user.setFirstName("Name"+id);
        user.setLastName("LastName"+id);
        user.setEmail("test@email.com"+id);
        user.setPhone("+5511999999999");
        user.setGender(Gender.MALE);
        user.setBirthDay(LocalDate.parse("1900-05-05"));

        return user;
    }

    //User Post DTO  for tests
    public UserPostDTO mockUserPostDTO(Integer id) {
        UserPostDTO userPostDTO = mock(UserPostDTO.class);

        userPostDTO.setId(id);
        userPostDTO.setFirstName("Name"+id);
        userPostDTO.setLastName("LastName"+id);
        userPostDTO.setEmail("test@email.com"+id);
        userPostDTO.setPhone("+5511999999999");
        userPostDTO.setGender(Gender.MALE);
        userPostDTO.setBirthDay(LocalDate.parse("1900-05-05"));
        userPostDTO.setPassword("password123");

        return userPostDTO;
    }
}
