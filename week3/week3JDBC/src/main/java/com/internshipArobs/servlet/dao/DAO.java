package com.internshipArobs.servlet.dao;

import com.internshipArobs.servlet.domain.Entity;

import java.sql.SQLException;

public interface DAO<ID, T extends Entity<ID>> {
    Iterable<T> findAll() throws SQLException;

    int save(T t) throws Exception;

    void update(T t) throws SQLException;

    void delete(ID id) throws SQLException;

    T findOne(ID id) throws SQLException;

}
