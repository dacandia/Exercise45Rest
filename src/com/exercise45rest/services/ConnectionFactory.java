package com.exercise45rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	//Singleton design
	
	//Declare properties objects
	static Properties properties = new Properties();
	static InputStream input = null;
	
	//Declare credential variables
	static String driver = "";
	static String urlServer = "";
	static String username = "";
	static String password = "";
	
	//Step 2. Instance of the clase must be private and static
	private static ConnectionFactory connection = null;
	private static Connection conn = null;
		
	public static Connection getConnection() {
		input = connection.getClass().getClassLoader().getResourceAsStream("dao.properties");
		try {
			properties.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(properties!=null) {
			driver = properties.getProperty("driver");
			urlServer = properties.getProperty("urlServer");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		}	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(urlServer, username, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//Step 1. Private constructor
	private void ConnectionFactory() {}
	
	//Step 3. Create getInstance method
	public static ConnectionFactory getInstance() {
		if(connection==null)
			connection = new ConnectionFactory();
		return connection;
	}
}
