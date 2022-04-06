package com.example.musify.hibernate;


import com.example.musify.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserService {
    private UserRepo userRepository;

    public UserService(UserRepo userRepo) {
        this.userRepository = userRepo;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    ;
}
