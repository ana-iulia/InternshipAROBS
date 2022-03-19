package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.repository.UserRepository;
import com.internshipArobs.servlet.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserService(userRepository);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("register", 0);
        context.setAttribute("service", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}