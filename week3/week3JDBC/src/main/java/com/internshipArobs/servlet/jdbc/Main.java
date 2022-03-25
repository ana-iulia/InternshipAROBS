package com.internshipArobs.servlet.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        ConnectionPool basicConnection = new BasicConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root", 3);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("E ok.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
            if (connection != null) {
                System.out.println("Connection ok.");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM Customer";
                ResultSet rs = statement.executeQuery(query);
                System.out.println("Inserting records into the table...");
//                String sql = "INSERT INTO Customer(first_name_c,last_name_c, phone_number_c) VALUES ('Crina', 'Anton', 0712345678)";
//                statement.executeUpdate(sql);
                String sql = "INSERT INTO Customer(first_name_c,last_name_c, phone_number_c) VALUES ('Andreea', 'Borcan', 0778942517)";
                statement.executeUpdate(sql);

                System.out.println("Inserted records into the table...");
                while (rs.next()) {
                    int id = rs.getInt("cod_c");
                    String first_name = rs.getString("first_name_c");
                    String last_name = rs.getString("last_name_c");
                    int phonenumber = rs.getInt("phone_number_c");
                    System.out.println("Registration: " + String.join(" ", String.valueOf(id), first_name, last_name, String.valueOf(phonenumber)));
                }
            } else {
                System.out.println("Connection not ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
