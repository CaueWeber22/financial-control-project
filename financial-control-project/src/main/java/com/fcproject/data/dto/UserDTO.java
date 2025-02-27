package com.fcproject.data.dto;

import java.io.Serializable;
import java.util.Objects;
import com.fcproject.data.models.Gender;


public class UserDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private long id;
    private String firstName;

    private String lastName;
    private String email;

    private String password;

    private String phone;

    private Gender gender;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDTO that)) return false;
        return getId() == that.getId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getPhone(), getGender());
    }
}
