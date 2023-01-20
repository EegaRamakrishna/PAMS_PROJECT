package com.revature.pams.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import org.junit.Test;

import com.revature.pams.dbconnection.Dbconnection;
import com.revature.pams.model.LoginCredentials;

public class LoginServiceTest {
	@Test
	public void userAuthenticateTest() throws ClassNotFoundException, SQLException {
		LoginCredentials  loginCredentials=new LoginCredentials();
		LoginService loginServiceTest=new LoginService();
		loginServiceTest.login(loginCredentials);
		Connection connection = Dbconnection.getConnection();
		PreparedStatement pst = connection.prepareStatement("select * from patient_registration where Name=? and password=?");
		pst.setString(1, loginCredentials.getUsername());
		pst.setString(2, loginCredentials.getPassword());
		ResultSet loginuser = pst.executeQuery();
		
		if (loginuser.next()) {
			loginCredentials.setLoginuserid(loginuser.getInt(1));
			loginCredentials.setLoginusername(loginuser.getString(2));
			loginCredentials.setLoginuserAge(loginuser.getInt(5));
			loginCredentials.setLoginPassword(loginuser.getString(6));
		}
		System.out.println(loginCredentials.getLoginusername()+"ttttttttttttttttt");
		assertNotEquals(loginCredentials.getLoginusername(),loginCredentials.getUsername());
		assertEquals(loginCredentials.getLoginPassword(),loginCredentials.getPassword());
//		assertEquals("siri", loginServiceTest);
	}
}
