package com.example.musify.service;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import org.webjars.NotFoundException;

public interface IUserService {
    String login(LoginRequestDTO loginRequest) throws NotFoundException;

    String logout(String token);

    UserDTO updateUserToDeleted(Integer id) throws IllegalArgumentException;

    UserDTO updateUser(Integer id, UserDTO userDTO) throws IllegalArgumentException;

    UserDTO saveRegularUser(UserRegisterDTO userDTO);

    UserDTO saveAdminUser(UserRegisterDTO userDTO) throws IllegalArgumentException;

    UserDTO saveMainAdminUser(UserRegisterDTO userDTO) throws IllegalArgumentException;
}
