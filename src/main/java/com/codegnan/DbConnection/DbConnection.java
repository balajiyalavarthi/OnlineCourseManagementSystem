package com.codegnan.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/coursemanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Balaji*1915111907";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

        // Explicitly enable auto-commit (MySQL defaults to true, but this ensures it stays on)
        conn.setAutoCommit(true);

        return conn;
    }
}
