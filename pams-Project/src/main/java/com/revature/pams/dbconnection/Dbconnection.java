package com.revature.pams.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Dbconnection
{
	private static Connection connection = null;

	private Dbconnection() {
	}

	public static Connection getConnection() {
		if (connection == null) {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("DataBase");
			String driver = resourceBundle.getString("driver");
			String dburl = resourceBundle.getString("dburl");
			String username = resourceBundle.getString("username");
			String password = resourceBundle.getString("password");

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, username, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}





//public class Dbcon {
//
//
//	public Connection connection;
//	
//	public Statement statement;
//    
//    private String password;
//	private String username;
//	private String url;
//
//	public Dbcon() throws ClassNotFoundException  {
//    	 this.url="jdbc:mysql://localhost:3306/PAMS_OWN";
//         this.username="root";
//         this.password="root";
//        
//        try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection=DriverManager.getConnection(url, username, password);
//			statement=connection.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    }
//}
