package com.internshipArobs.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnection implements ConnectionPool {
    private String connectionString;
    private String user;
    private String password;
    private int maxSize;
    private List<Connection> connectionAvailableList = new ArrayList<>();
    private List<Connection> connectionUsedList = new ArrayList<>();

    public BasicConnection(String connectionString, String user, String password, int maxSize) {
        this.connectionString = connectionString;
        this.user = user;
        this.password = password;
        this.maxSize = maxSize;
        for (int i = 0; i < maxSize; i++) {
            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
                if (connection != null) {
                    connectionAvailableList.add(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public Connection getConnection() {
        if (!connectionAvailableList.isEmpty()) {
            Connection connection = connectionAvailableList.remove(connectionAvailableList.size() - 1);
            connectionUsedList.add(connection);
            return connection;
        }
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {
        connectionUsedList.remove(connection);
        connectionAvailableList.add(connection);


    }
}
