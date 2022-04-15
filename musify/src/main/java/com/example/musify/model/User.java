package com.example.musify.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "from User"),
        //@NamedQuery(name = "findArtistById", query = "from Artist where id = :id")
})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "origin_country")
    private String countryOfOrigin;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Playlist> playlists;

    @ManyToMany
    private List<Playlist> followedPlaylists;

}
