package com.example.musify.repository;
import com.example.musify.model.User;
import com.example.musify.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

//@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;


    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public User saveUser(User user) {
        String query = "INSERT INTO Users(first_name, last_name, email, password, country_of_origin, role, status ) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCountryOfOrigin(), user.getRole().toString(), user.getStatus().toString());
        return user;
        //new UserRegisterDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCountryOfOrigin());
    }

    public User findByEmail(String email) {
        String query = "SELECT * FROM Users WHERE email=?";
        return jdbcTemplate.queryForObject(query, new UserRowMapper(), email);

    }

    public User findById(int id) {
        String query = "SELECT * FROM Users WHERE id=?";
        return jdbcTemplate.queryForObject(query, new UserRowMapper(), id);

    }

    public int deleteUser(int id) {
        String query = "DELETE FROM Users WHERE id=?";
        return jdbcTemplate.update(query, id);
    }

    public int updateUser(User user) {
        String query = "UPDATE Users SET first_name=?, last_name=?, email=?, password=?, country_of_origin=?, role=?, status=? WHERE id=?";
        return jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCountryOfOrigin(), user.getRole().toString(), user.getStatus().toString(), user.getId());
    }


}
