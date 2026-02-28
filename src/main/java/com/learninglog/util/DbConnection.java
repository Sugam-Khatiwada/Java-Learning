package com.learninglog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static String URL = "jdbc:mysql://localhost:3306/learninglog";
    static String USERNAME = "root";
    static String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
}
}