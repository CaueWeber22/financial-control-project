package com.fcproject.TestsMocks;

import com.fcproject.data.dto.userDTO.UserDTO;
import com.fcproject.data.dto.userDTO.UserPostDTO;
import com.fcproject.data.models.Gender;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMocks {

    public UserDTO mockUserDTO(Integer id) {
        UserDTO userDTO = mock(UserDTO.class);

        when(userDTO.getId()).thenReturn(Long.valueOf(id));
        when(userDTO.getFirstName()).thenReturn("Name"+id);
        when(userDTO.getLastName()).thenReturn("LastName"+id);
        when(userDTO.getEmail()).thenReturn("test@email.com"+id);
        when(userDTO.getPhone()).thenReturn("+5511999999999");
        when(userDTO.getGender()).thenReturn(Gender.MALE);
        when(userDTO.getBirthDay()).thenReturn(LocalDate.of(1990, 5, 15));

        return userDTO;
    }
    public UserPostDTO mockUserPostDTO(Integer id) {
        UserPostDTO userPostDTO = mock(UserPostDTO.class);

        when(userPostDTO.getId()).thenReturn(2L);
        when(userPostDTO.getFirstName()).thenReturn("Name"+id);
        when(userPostDTO.getLastName()).thenReturn("LastName"+id);
        when(userPostDTO.getEmail()).thenReturn("test@email.com"+id);
        when(userPostDTO.getPhone()).thenReturn("+5511988888888");
        when(userPostDTO.getGender()).thenReturn(Gender.FEMALE);
        when(userPostDTO.getBirthDay()).thenReturn(LocalDate.of(1995, 8, 20));
        when(userPostDTO.getPassword()).thenReturn("Password123");

        return userPostDTO;
    }
}
