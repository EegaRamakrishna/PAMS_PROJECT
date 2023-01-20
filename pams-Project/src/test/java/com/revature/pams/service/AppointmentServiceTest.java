
package com.revature.pams.service;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import com.revature.pams.dbconnection.Dbconnection;
import com.revature.pams.model.LoginCredentials;


public class AppointmentServiceTest {
	
	
	@Test
	void appointmentServiceTest() throws SQLException {
		AppointmentService appointmentService=new AppointmentService();
		LoginCredentials loginCredentialsobj=new LoginCredentials();
		appointmentService.bookingAppointment();
		Connection connection = null;
		connection = Dbconnection.getConnection();
		PreparedStatement pst = connection.prepareStatement("select * from Receptionist where Receptionist_name=? and Password=?");
		pst.setString(1, loginCredentialsobj.getUsername());
		pst.setString(2, loginCredentialsobj.getPassword());
		ResultSet loginTest=pst.executeQuery();
		if (loginTest.next()) {
			loginCredentialsobj.setLoginusername(loginTest.getString(2));
			loginCredentialsobj.setLoginuserAge(loginTest.getInt(5));
		}
		
	}
}
