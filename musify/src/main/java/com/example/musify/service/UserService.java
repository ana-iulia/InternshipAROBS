package com.example.musify.service;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.mapper.UserMapper;
import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import com.example.musify.repository.springdata.UserRepository;
import com.example.musify.security.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public String login(LoginRequestDTO loginRequest) throws NotFoundException {
        User user = userMapper.loginToUser(loginRequest);
        user = userRepository.findByEmail(user.getEmail());
        if (user != null) {
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new NotFoundException("Bad credentials");

            }
            return jwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole(), "valid");
        }
        throw new NotFoundException("Bad credentials");
    }

    @Override
    public String logout(String token) {
        jwtUtils.invalidateToken(token);
        return "invalidated";
    }


    @Override
    @Transactional
    public UserDTO updateUserToDeleted(Integer id) {
        User user = userRepository.getById(id);
        user.setStatus(Status.DELETED);
        return userMapper.toUserDTO(user);

    }

    @Override
    @Transactional
    public UserDTO saveRegularUser(UserRegisterDTO userDTO) {
        User user = userMapper.toUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.REGULAR);
        return userMapper.toUserDTO(userRepository.save(user));

    }

    @Override
    @Transactional
    public UserDTO saveAdminUser(UserRegisterDTO userDTO, String token) throws IllegalArgumentException {
        if (jwtUtils.getRoleFromToken(token).equals(Role.ADMIN)) {
            User user = userMapper.toUserEntity(userDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setStatus(Status.ACTIVE);
            user.setRole(Role.ADMIN);
            return userMapper.toUserDTO(userRepository.save(user));
        }

        throw new IllegalArgumentException("You do not have permission for this request.");

    }
}
