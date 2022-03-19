package com.internshipArobs.servlet.service;

import com.internshipArobs.servlet.domain.User;
import com.internshipArobs.servlet.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) throws Exception {

        return userRepository.findUser(email, password);

    }

    @Override
    public void registerUser(String name, String email, String password) throws Exception {
        User user = new User(name, email, password);
        userRepository.addUser(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.getUsers();
    }
}
