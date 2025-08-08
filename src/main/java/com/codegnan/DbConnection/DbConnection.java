package com.codegnan.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String jdbc_url= "jdbc:mysql://localhost:3306/coursemanagement";
	private static final String userName= "root";
	private static final String password= "Balaji*1915111907";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(jdbc_url, userName, password);
	}
}
