package com.child.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	static Connection conn = null;
	//static String url = "jdbc:mysql://localhost:3306/cps";
	static String url = "jdbc:mysql://instance25735.db.xeround.com:16871/childtrack";
/**
 * Credentials of Database.
 * @return
 */
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

//			String username = "root"; // "e539022";
//			String password = "root"; // "zqbAlmQox";
			String username = "dharani"; // "e539022";
			String password = "dharani"; // "zqbAlmQox";

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
