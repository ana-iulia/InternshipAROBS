package com.example.musify.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequest {
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "Email invalid!")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    public String getPassword() {
        return password;
    }

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
