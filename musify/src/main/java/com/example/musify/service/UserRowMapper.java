package com.example.musify.service;

import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCountryOfOrigin(rs.getString("country_of_origin"));
        Role role = Role.REGULAR;
        if (rs.getString("role").equals("ADMIN")) {
            role = Role.ADMIN;
        }
        user.setRole(role);
        Status status = Status.ACTIVE;
        if (rs.getString("status").equals("DELETED")) {
            status = Status.DELETED;
        }
        user.setStatus(status);
        return user;

    }
}
