package com.example.musify.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRegisterDTO {
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "Email invalid!")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    private String countryOfOrigin;


    public UserRegisterDTO() {

    }

    public UserRegisterDTO(String firstName, String lastName, String email, String password, String countryOfOrigin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.countryOfOrigin = countryOfOrigin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

}
