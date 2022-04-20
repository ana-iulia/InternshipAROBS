package com.example.musify.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserTest {
    private User user;
    private User user2;
    private Integer id = 1;
    private String firstName = "testFName";
    private String lastName = "testLName";
    private String email = "test@gmail.com";
    private String password = "password";
    private String countryOfOrigin = "testCountry";
    private Role role = Role.REGULAR;
    private Status status = Status.ACTIVE;
    private List<Playlist> playlists = null;
    private List<Playlist> followedPlaylists = null;

    @BeforeEach
    void setUp() {
        user = new User(id, firstName, lastName, email, password, countryOfOrigin, role, status, playlists, followedPlaylists);
        user2=new User();
    }


    @Test
    void getId() {
        assertEquals(id, user.getId());
    }

    @Test
    void getFirstName() {
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(lastName, user.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals(email, user.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    void getCountryOfOrigin() {
        assertEquals(countryOfOrigin, user.getCountryOfOrigin());
    }

    @Test
    void getRole() {
        assertEquals(role, user.getRole());
    }

    @Test
    void getStatus() {
        assertEquals(status, user.getStatus());
    }

    @Test
    void getPlaylists() {
        assertEquals(playlists, user.getPlaylists());
    }

    @Test
    void getFollowedPlaylists() {
        assertEquals(followedPlaylists, user.getFollowedPlaylists());
    }

    @Test
    void setId() {
        user2.setId(2);
        assertEquals(user2.getId(), 2);
    }

    @Test
    void setFirstName() {
        user2.setFirstName("test2");
        assertEquals(user2.getFirstName(), "test2");
    }

    @Test
    void setLastName() {
        user2.setLastName("test2");
        assertEquals(user2.getLastName(), "test2");
    }

    @Test
    void setEmail() {
        user2.setEmail("email");
        assertEquals(user2.getEmail(), "email");
    }

    @Test
    void setPassword() {
        user2.setPassword("pass");
        assertEquals(user2.getPassword(), "pass");
    }

    @Test
    void setCountryOfOrigin() {
        user2.setCountryOfOrigin("test");
        assertEquals(user2.getCountryOfOrigin(),"test");
    }

    @Test
    void setRole() {
        user2.setRole(Role.ADMIN);
        assertEquals(user2.getRole(),Role.ADMIN);
    }

    @Test
    void setStatus() {
        user2.setStatus(Status.DELETED);
        assertEquals(user2.getStatus(),Status.DELETED);
    }

//    @Test
//    void setPlaylists() {
//
//    }
//
//    @Test
//    void setFollowedPlaylists() {
//    }
}