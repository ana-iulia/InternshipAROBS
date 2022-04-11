package com.example.musify.service;

import com.example.musify.dto.LoginRequest;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import com.example.musify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    public UserDTO saveUser(UserRegisterDTO userDTO) {
//        User user = userMapper.toUserEntity(userDTO);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setStatus(Status.ACTIVE);
//        user.setRole(Role.REGULAR);
//        return userMapper.toUserDTO(userRepository.saveUser(user));
//    }
//
//    public UserDTO saveUserAdmin(UserRegisterDTO userDTO) {
//        User user = userMapper.toUserEntity(userDTO);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setStatus(Status.ACTIVE);
//        user.setRole(Role.ADMIN);
//        return userMapper.toUserDTO(userRepository.saveUser(user));
//    }
//
//    public String login(LoginRequest loginRequest) {
//        User user = userMapper.loginToUser(loginRequest);
//        user = userRepository.findByEmail(user.getEmail());
//        if (user != null) {
//            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//               // return user.getId();
//                return jwtUtils.generateToken(user.getId(),user.getEmail(),user.getRole(),"valid");
//            }
//        }
//        return null;
//    }
//
//    public String logout(String token) {
//        jwtUtils.invalidateToken(token);
//        return "invalidated";
//    }
//
//    public int deleteUser(int id) {
//        return userRepository.deleteUser(id);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.getAllUsers();
//    }
//
//    public Iterable<UserDTO> getAllUsersDTO() {
//        List<UserDTO> users = new ArrayList<>();
//        userRepository.getAllUsers()
//                .forEach(user -> users.add(userMapper.toUserDTO(user)));
//        return users;
//    }
//
//
//    public UserDTO updateUserToDeleted(Integer id) {
//        User user = userRepository.findById(id);
//        user.setStatus(Status.DELETED);
//        userRepository.updateUser(user);
//        return userMapper.toUserDTO(user);
//
//    }



//}
