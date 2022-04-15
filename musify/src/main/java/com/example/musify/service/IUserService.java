package com.example.musify.service;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;

public interface IUserService {
    String login(LoginRequestDTO loginRequest) throws Exception;

    String logout(String token);

    UserDTO updateUserToDeleted(Integer id);

    UserDTO saveUser(UserRegisterDTO userDTO, Role role);
}
