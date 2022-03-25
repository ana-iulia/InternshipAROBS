package com.internshipArobs.servlet.service;

import com.internshipArobs.servlet.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    Customer login(String firstName, String lastName, Long phoneNumber)throws Exception;
    void registerCustomer(String firstName, String lastName, Long phoneNumber) throws SQLException, Exception;
    List<Customer> findAll() throws SQLException;
    void deleteAccount(Long id) throws SQLException;
    void updateAccount(Customer oldCustomer, String firstName, String lastName, Long phoneNumber) throws SQLException;

}
