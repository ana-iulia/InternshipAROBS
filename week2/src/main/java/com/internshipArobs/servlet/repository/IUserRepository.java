package com.internshipArobs.servlet.repository;

import com.internshipArobs.servlet.domain.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUsers();
    void addUser(User user) throws Exception;
    User findUser(String email,String password) throws Exception;


}
