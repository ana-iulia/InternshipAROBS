package com.example.musify.service;

import com.example.musify.dto.LoginRequest;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import com.example.musify.repository.springdata.UserRepository;
import com.example.musify.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserServ {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String login(LoginRequest loginRequest) {
        User user = userMapper.loginToUser(loginRequest);
        user = userRepository.findByEmail(user.getEmail());
        System.out.println("Email" + user.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                // return user.getId();
                return jwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole(), "valid");
            }
        }
        return null;
    }

    public User getUserById(int id) {

        return userRepository.getById(id);
    }

    public UserDTO saveUser(UserRegisterDTO userDTO) {
        User user = userMapper.toUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.REGULAR);
        return userMapper.toUserDTO(userRepository.save(user));
    }
}
