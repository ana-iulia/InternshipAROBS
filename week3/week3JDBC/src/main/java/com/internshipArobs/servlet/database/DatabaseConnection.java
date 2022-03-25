package com.internshipArobs.servlet.database;

import com.internshipArobs.servlet.jdbc.HikariConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    static {

        String url = "jdbc:mysql://localhost:3306/restaurant";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(url, user, pass);
            HikariConnection hikariConnection = new HikariConnection(url, user, pass, 3);
            connection = hikariConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
