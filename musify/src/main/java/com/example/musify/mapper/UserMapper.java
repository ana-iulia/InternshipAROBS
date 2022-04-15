package com.example.musify.mapper;
import com.example.musify.dto.LoginRequestDTO;
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
    User loginToUser(LoginRequestDTO loginRequest);

    UserDTO toUserDTO(User user);

}
