package com.internshipArobs.servlet.service;

import com.internshipArobs.servlet.dbRepository.OrderMenuItemRepository;
import com.internshipArobs.servlet.domain.OrderMenuItem;

import java.sql.SQLException;
import java.util.List;

public class OrderMenuItemService implements IOrderMenuItemService {
    OrderMenuItemRepository orderMenuItemRepository = new OrderMenuItemRepository();

    public OrderMenuItemService(OrderMenuItemRepository orderMenuItemRepository) {
        this.orderMenuItemRepository = orderMenuItemRepository;
    }

    @Override
    public List<OrderMenuItem> findAll() throws SQLException {
        return orderMenuItemRepository.findAll();
    }
}
