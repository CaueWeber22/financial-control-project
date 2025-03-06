package com.fcproject.data.dto.userDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fcproject.data.models.Gender;
import com.fcproject.data.models.UserEntity;


public class UserDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String phone;
    private Gender gender;

    @JsonProperty("date_of_birth")
    private LocalDate birthDay;

    //Constructor
    public UserDTO() {}

    //Getters and Setters
    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDay() {return birthDay;}

    public void setBirthDay(LocalDate birthDay) {this.birthDay = birthDay;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserEntity that)) return false;
        return getId() == that.getId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhone(), that.getPhone()) && getGender() == that.getGender() && Objects.equals(getBirthDay(), that.getBirthDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPhone(), getGender(), getBirthDay());
    }
}
