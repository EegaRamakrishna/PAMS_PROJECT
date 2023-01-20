package com.dbconn;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.BeforeClass;


import com.revature.pams.dbconnection.Dbconnection;

public class DbconTest {
	
	@BeforeClass
	public void testDbconnection() {

		Connection connecion = Dbconnection.getConnection();
		assertNotNull(connecion);
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
