package com.internshipArobs.servlet.service;

import com.internshipArobs.servlet.domain.User;

import java.util.List;

public interface IUserService {

    User login(String email,String password)throws Exception;
    void registerUser(String name, String email, String password) throws Exception;

    List<User> findAll();
}
