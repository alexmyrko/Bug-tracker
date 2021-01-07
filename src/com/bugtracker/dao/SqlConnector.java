package com.bugtracker.dao;

import java.sql.*;

public class SqlConnector {
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/bt?useSSL=false&serverTimezone=UTC";
    public static final String USERNAME = "cursor";
    public static final String PASSWORD = "cursor_123";
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null)
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println(e);
            }
        return connection;
    }
}
