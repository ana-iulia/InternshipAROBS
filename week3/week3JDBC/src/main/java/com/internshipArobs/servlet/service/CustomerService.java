package com.internshipArobs.servlet.service;

import com.internshipArobs.servlet.dbRepository.CustomerRepository;
import com.internshipArobs.servlet.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer login(String firstName, String lastName, Long phoneNumber) throws Exception {
        Customer customer = customerRepository.findByNamePhone(firstName, lastName, phoneNumber);
        if (customer == null) {
            throw new Exception("Customer does not exist!");
        }
        return customer;
    }

    @Override
    public void registerCustomer(String firstName, String lastName, Long phoneNumber) throws Exception {
        Customer customer = new Customer(firstName, lastName, phoneNumber);
        customerRepository.save(customer);

    }

    @Override
    public List<Customer> findAll() throws SQLException {
        return customerRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) throws SQLException {
        customerRepository.delete(id);
    }

    @Override
    public void updateAccount(Customer oldCustomer, String firstName, String lastName, Long phoneNumber) throws SQLException {
        if (!firstName.equals("")) {
            oldCustomer.setFirstName(firstName);
        }
        if (!lastName.equals("")) {
            oldCustomer.setLastName(lastName);
        }
        if (phoneNumber != null) {
            oldCustomer.setPhoneNumber(phoneNumber);
        }
        System.out.println("Customer: " + String.join(",", oldCustomer.getFirstName(), oldCustomer.getLastName(), String.valueOf(oldCustomer.getPhoneNumber())));
        customerRepository.update(oldCustomer);
    }
}
