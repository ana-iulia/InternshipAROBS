package com.internshipArobs.servlet.jdbc;

import com.internshipArobs.servlet.dbRepository.CustomerRepository;
import com.internshipArobs.servlet.domain.Customer;
import com.internshipArobs.servlet.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args)
            throws SQLException {

        Customer emp = new Customer();
        emp.setFirstName("Haider");
        emp.setLastName("Mars");
        emp.setPhoneNumber(Long.valueOf("40789456123"));
        CustomerRepository empDao = new CustomerRepository();
        CustomerService customerService = new CustomerService(empDao);
        System.out.println(emp.getId() + " "
                           + emp.getFirstName() + " "
                           + emp.getLastName() + " "
                           + emp.getPhoneNumber());

        // add
        try {
            customerService.registerCustomer(emp.getFirstName(), emp.getLastName(), emp.getPhoneNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // read
        Customer e = customerService.findAll().get(0);
        System.out.println(e.getId() + " "
                           + e.getFirstName() + " "
                           + e.getLastName() + " "
                           + e.getPhoneNumber());

        // read All
        List<Customer> ls = empDao.findAll();
        for (Customer allEmp : ls) {
            System.out.println(allEmp);
        }

        // update
        Customer tempCustomer = empDao.findOne(1L);
        tempCustomer.setFirstName("Asgard");
        customerService.updateAccount(tempCustomer, "ceva", "", Long.valueOf(""));
        empDao.update(tempCustomer);
        // read
        e = customerService.findAll().get(0);
        System.out.println(e.getId() + " "
                           + e.getFirstName() + " "
                           + e.getLastName() + " "
                           + e.getPhoneNumber());
        // delete
        empDao.delete(1L);
    }
}