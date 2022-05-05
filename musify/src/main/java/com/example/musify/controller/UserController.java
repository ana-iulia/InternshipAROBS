package com.example.musify.controller;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
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
import java.util.Objects;


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
    public ResponseEntity<UserDTO> registerAdmin(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveAdminUser(userDTO));
    }

    @PostMapping("/user/registration-main-admin")
    public ResponseEntity<UserDTO> registerMainAdmin(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveMainAdminUser(userDTO));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.updateUserToDeleted(id));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.updateUser(id, userDTO));
    }

    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = Objects.requireNonNull(headers.getFirst("authorization")).split(" ");
        return ResponseEntity.ok().body(userService.logout(words[1]));

    }


}
