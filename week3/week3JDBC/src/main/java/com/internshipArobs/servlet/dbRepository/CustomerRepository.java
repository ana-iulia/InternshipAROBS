package com.internshipArobs.servlet.dbRepository;

import com.internshipArobs.servlet.dao.CustomerDAO;
import com.internshipArobs.servlet.database.DatabaseConnection;
import com.internshipArobs.servlet.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepository implements CustomerDAO<Long, Customer> {
    static Connection con
            = DatabaseConnection.getConnection();

    @Override
    public List<Customer> findAll() throws SQLException {
        String query = "SELECT * FROM Customer";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Customer> customerList = new ArrayList();

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getLong("cod_c"));
            customer.setFirstName(rs.getString("first_name_c"));
            customer.setLastName(rs.getString("last_name_c"));
            customer.setPhoneNumber(rs.getLong("phone_number_c"));
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public int save(Customer customer) throws Exception {
        if (customer.getFirstName().equals("") || customer.getLastName().equals("") || customer.getPhoneNumber() == null) {
            throw new Exception("Empty fields are not accepted.");
        }
        for (Customer c : findAll()) {
            if (c.getPhoneNumber().equals(customer.getPhoneNumber())) {
                throw new Exception("There already exists an account with this phone number.");
            }

        }

        String query
                = "INSERT INTO Customer(first_name_c, last_name_c, phone_number_c) " +
                  "VALUES (?, ?, ?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setLong(3, customer.getPhoneNumber());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void update(Customer customer) throws SQLException {

        String query
                = "UPDATE Customer SET first_name_c=?, last_name_c=?, phone_number_c=? where cod_c = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setLong(3, customer.getPhoneNumber());
        ps.setLong(4, customer.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String query
                = "DELETE FROM Customer WHERE cod_c =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public Customer findOne(Long id) throws SQLException {

        String query
                = "SELECT * FROM Customer WHERE cod_c= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setLong(1, id);
        Customer customer = new Customer();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            customer.setId(rs.getLong("cod_c"));
            customer.setFirstName(rs.getString("first_name_c"));
            customer.setLastName(rs.getString("last_name_c"));
            customer.setPhoneNumber(rs.getLong("phone_number_c"));
        }

        if (check == true) {
            return customer;
        } else
            return null;
    }

    @Override
    public Customer findByNamePhone(String firstName, String lastName, Long phoneNumber) throws SQLException {

        String query
                = "SELECT * FROM Customer WHERE (first_name_c= ? AND last_name_c=? AND phone_number_c=?)";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setLong(3, phoneNumber);
        Customer customer = new Customer();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            customer.setId(rs.getLong("cod_c"));
            customer.setFirstName(rs.getString("first_name_c"));
            customer.setLastName(rs.getString("last_name_c"));
            customer.setPhoneNumber(rs.getLong("phone_number_c"));
        }

        if (check == true) {
            return customer;
        } else
            return null;
    }
}
