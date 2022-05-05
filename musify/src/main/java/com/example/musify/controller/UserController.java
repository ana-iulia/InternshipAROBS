package com.example.musify.controller;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/musify")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveRegularUser(userDTO));
    }


    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDTO loginRequest) throws NotFoundException {
        return ResponseEntity.ok().body(userService.login(loginRequest));
    }

    @PostMapping("/user/registration-admin")
    public ResponseEntity<UserDTO> registerAdmin(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid UserRegisterDTO userDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(userService.saveAdminUser(userDTO, words[1]));
    }

    @PostMapping("/user/registration-main-admin")
    public ResponseEntity<UserDTO> registerMainAdmin(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveMainAdminUser(userDTO));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserDTO> deleteUser(@RequestHeader("authorization") HttpHeaders headers, @PathVariable("id") Integer id) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(userService.updateUserToDeleted(id, words[1]));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestHeader("authorization") HttpHeaders headers, @PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(userService.updateUser(id, userDTO, words[1]));
    }

    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(userService.logout(words[1]));

    }


}
