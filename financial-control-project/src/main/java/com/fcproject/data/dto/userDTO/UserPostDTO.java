package com.fcproject.data.dto.userDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fcproject.data.models.Gender;
import com.fcproject.data.models.UserEntity;


public class UserPostDTO extends UserDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    
    private String password;

    //Constructor
    public UserPostDTO() {}

    //Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserEntity that)) return false;
        return getId() == that.getId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getPhone(), that.getPhone()) && getGender() == that.getGender() && Objects.equals(getBirthDay(), that.getBirthDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getPhone(), getGender(), getBirthDay());
    }
}
