package com.internshipArobs.servlet.repository;

import com.internshipArobs.servlet.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private int id = 0;
    private List<User> users = new ArrayList<>();


    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) throws Exception {
        if (user.getEmail().equals("") || user.getPassword().equals("") || user.getName().equals("")) {
            throw new Exception("Empty fields are not accepted.");
        }
        if (!user.getEmail().matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
            throw new Exception("Invalid email.");
        }
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                throw new Exception("There already exists an account with this email.");
            }

        }
        id++;
        user.setId(id);
        users.add(user);

    }

    @Override
    public User findUser(String email, String password) throws Exception {
        for (User user:users) {
            if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                return user;
            }

        }
        throw new Exception("User does not exist!");
    }
}
