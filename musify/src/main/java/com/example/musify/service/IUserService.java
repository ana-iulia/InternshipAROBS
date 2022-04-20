package com.example.musify.service;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import org.webjars.NotFoundException;

public interface IUserService {
    String login(LoginRequestDTO loginRequest) throws NotFoundException;

    String logout(String token);

    UserDTO updateUserToDeleted(Integer id);

    UserDTO saveRegularUser(UserRegisterDTO userDTO);

    UserDTO saveAdminUser(UserRegisterDTO userDTO, String token) throws IllegalArgumentException;
}
