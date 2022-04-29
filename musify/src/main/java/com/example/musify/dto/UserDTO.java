package com.example.musify.dto;

import com.example.musify.model.Playlist;
import com.example.musify.model.Role;
import com.example.musify.model.Status;
import lombok.*;

import java.util.List;

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
    //private List<Playlist> playlists;
    //private List<Playlist> followedPlaylists;

}
