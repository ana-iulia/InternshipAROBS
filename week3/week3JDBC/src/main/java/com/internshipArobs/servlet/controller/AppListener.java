package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.dbRepository.CustomerRepository;
import com.internshipArobs.servlet.dbRepository.OrderMenuItemRepository;
import com.internshipArobs.servlet.service.CustomerService;
import com.internshipArobs.servlet.service.OrderMenuItemService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
    private CustomerRepository customerRepository = new CustomerRepository();
    private CustomerService customerService = new CustomerService(customerRepository);
    private OrderMenuItemRepository orderMenuItemRepository = new OrderMenuItemRepository();
    private OrderMenuItemService orderMenuItemService = new OrderMenuItemService(orderMenuItemRepository);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("register", 0);
        context.setAttribute("customerService", customerService);
        context.setAttribute("orderMenuItemService", orderMenuItemService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}