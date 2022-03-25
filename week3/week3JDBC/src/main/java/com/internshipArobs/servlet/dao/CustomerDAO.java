package com.internshipArobs.servlet.dao;

import com.internshipArobs.servlet.domain.Customer;
import com.internshipArobs.servlet.domain.Entity;

public interface CustomerDAO<ID,T extends Entity<ID>> extends DAO<ID,T> {

    Customer findByNamePhone(String firstNam, String lastName, Long phoneNumber) throws Exception;
}
