package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

}
