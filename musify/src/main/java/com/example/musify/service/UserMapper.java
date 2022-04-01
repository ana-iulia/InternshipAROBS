package com.example.musify.service;

import com.example.musify.dto.LoginRequest;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRegisterDTO toUserRegisterDTO(User user);

    @Mapping(target = "password", source = "password")
    User toUserEntity(UserRegisterDTO userDTO);

    @Mapping(target = "password", source = "password")
    User loginToUser(LoginRequest loginRequest);

    UserDTO toUserDTO(User user);

}
