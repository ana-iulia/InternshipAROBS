package com.example.musify.controller;

import com.example.musify.dto.LoginRequest;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.User;
import com.example.musify.service.UserServ;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/musify/user")
public class UserController {
    @Autowired
    private UserServ userService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Valid UserRegisterDTO userDTO) {
        return userService.saveUser(userDTO);
    }


    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

//    @PostMapping("/register/admin")
//    public UserDTO registerAdmin(@RequestBody @Valid UserRegisterDTO userDTO) {
//        return userService.saveUserAdmin(userDTO);
//    }

//
//    @PutMapping("/delete/{id}")
//    public UserDTO deleteUser(@PathVariable("id") Integer id) {
//        System.out.println("ID: " + id);
//        return userService.updateUserToDeleted(id);
//    }
//
//    @PostMapping("/logout")
//    public String logout(@RequestHeader("authorization") HttpHeaders headers) {
//        String[] words = headers.getFirst("authorization").split(" ");
//        return userService.logout(words[1]);
//
//    }


}
