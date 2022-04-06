package com.example.musify;

import com.example.musify.hibernate.UserRepo;
import com.example.musify.hibernate.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class MusifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusifyApplication.class, args);

        UserRepo userRepo = new UserRepo();
        UserService userService = new UserService(userRepo);
        userService.getUsers().forEach(user -> System.out.println(String.format(",", user.getId(), user.getFirstName(), user.getLastName(), user.getEmail())));
    }

}
