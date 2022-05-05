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


}
