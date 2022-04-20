package com.example.musify.integrationTests;

import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import com.example.musify.repository.springdata.UserRepository;
import com.example.musify.service.IUserService;
import com.example.musify.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;
@ExtendWith(MockitoExtension.class)
public class UserServiceRepoDomainTest {
    private User user;
    private UserRepository userRepository;
    private IUserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User(1, "TestFirstName", "TestLastName", "test@email.com", "password", "Romania", Role.REGULAR, Status.ACTIVE, null, null);
        userService=new UserService();
    }

    @Test
    public void givenValidUser_whenSave_thenEntityIsSaved() {

    }

}
