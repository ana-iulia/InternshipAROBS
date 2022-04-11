package com.example.musify.model;


import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "from User"),
        //@NamedQuery(name = "findArtistById", query = "from Artist where id = :id")
})
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_ame", nullable = false)
    private String firstName;

    @Column(name = "last_ame", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "origin_country")
    private String countryOfOrigin;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "status", nullable = false)
    private Status status;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Playlist> playlists;

    @ManyToMany
    private List<Playlist> followedPlaylists;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String password, String countryOfOrigin, Role role, Status status, List<Playlist> playlists, List<Playlist> followedPlaylists) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.countryOfOrigin = countryOfOrigin;
        this.role = role;
        this.status = status;
        this.playlists = playlists;
        this.followedPlaylists = followedPlaylists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
