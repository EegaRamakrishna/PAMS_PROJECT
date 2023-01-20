package com.revature.pams.service;


import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import com.revature.pams.dbconnection.Dbconnection;


public class ReceptionistTest {
	 public String receptionistname;
	public void receptionist() throws ClassNotFoundException, SQLException {
	 
		Connection connection = Dbconnection.getConnection();
		Statement statement=connection.createStatement();
	 
	 
	 try {
		 	
		 ResultSet receptionist_name=statement.executeQuery("select Receptionist_name from Receptionist where current_time() between  Receptionist_startime and Receptionist_endtime");
			
			if(receptionist_name.next()) {
				receptionistname=receptionist_name.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
 }
}
