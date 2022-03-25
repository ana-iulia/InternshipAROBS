package com.internshipArobs.servlet.service;
import com.internshipArobs.servlet.domain.OrderMenuItem;

import java.sql.SQLException;
import java.util.List;

public interface IOrderMenuItemService {
    List<OrderMenuItem> findAll() throws SQLException;
}
