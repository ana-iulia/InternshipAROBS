package com.example.musify.dto;

import com.example.musify.model.Role;
import com.example.musify.model.Status;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String countryOfOrigin;
    private Role role;
    private Status status;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String email, String countryOfOrigin, Role role, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.countryOfOrigin = countryOfOrigin;
        this.role = role;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
