package com.example.musify.dto;


import com.example.musify.model.Role;
import com.example.musify.model.Status;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String countryOfOrigin;
    private Role role;
    private Status status;

}
