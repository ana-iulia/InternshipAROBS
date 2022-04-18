package com.example.musify.controller;

import com.example.musify.dto.LoginRequestDTO;
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
@RequestMapping("/musify/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveUser(userDTO,Role.REGULAR));
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDTO loginRequest) throws NotFoundException {
        return ResponseEntity.ok().body(userService.login(loginRequest));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<UserDTO> registerAdmin(@RequestBody @Valid UserRegisterDTO userDTO) {
        return ResponseEntity.ok().body(userService.saveUser(userDTO, Role.ADMIN));
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Integer id) {
        System.out.println("ID: " + id);
        return ResponseEntity.ok().body(userService.updateUserToDeleted(id));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(userService.logout(words[1]));

    }


}
