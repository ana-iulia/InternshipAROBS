package com.internshipArobs.servlet.dbRepository;

import com.internshipArobs.servlet.dao.OrderMenuItemDAO;
import com.internshipArobs.servlet.database.DatabaseConnection;
import com.internshipArobs.servlet.domain.OrderMenuItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMenuItemRepository implements OrderMenuItemDAO<Long, OrderMenuItem> {
    static Connection con
            = DatabaseConnection.getConnection();


    @Override
    public List<OrderMenuItem> findAll() throws SQLException {
        String query = "SELECT * FROM OrderMenuItem";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<OrderMenuItem> itemList = new ArrayList();

        while (rs.next()) {
            OrderMenuItem orderMenuItem = new OrderMenuItem();
            orderMenuItem.setId(rs.getLong("item_id"));
            orderMenuItem.setName(rs.getString("name"));
            orderMenuItem.setDescription(rs.getString("description"));
            orderMenuItem.setPrice(rs.getFloat("price"));

            itemList.add(orderMenuItem);
        }
        return itemList;
    }

    @Override
    public int save(OrderMenuItem orderMenuItem) throws Exception {
        return 0;
    }

    @Override
    public void update(OrderMenuItem orderMenuItem) throws SQLException {

    }

    @Override
    public void delete(Long aLong) throws SQLException {

    }

    @Override
    public OrderMenuItem findOne(Long aLong) throws SQLException {
        return null;
    }


}
