package com.example.musify.dto;

import com.example.musify.model.Role;
import com.example.musify.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String countryOfOrigin;
    private Role role;
    private Status status;

}
