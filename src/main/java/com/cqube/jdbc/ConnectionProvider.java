package com.cqube.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	private static String url;
	private static Connection connection;

	static {
		Properties properties = new Properties();
		try {
			properties.load(ConnectionProvider.class.getResourceAsStream("/env.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		url = properties.getProperty("datasource");
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
	
	public static void freeConnection() {
		try {
			if (!(connection == null) && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

}