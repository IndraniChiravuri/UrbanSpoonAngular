package com.ts.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtility {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/us_db", "root", "root");
			System.out.println("connection established");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

}
