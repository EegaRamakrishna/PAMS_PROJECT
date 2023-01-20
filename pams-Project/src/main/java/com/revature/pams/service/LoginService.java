package com.revature.pams.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.pams.constant.Content;
import com.revature.pams.dbconnection.Dbconnection;
import com.revature.pams.model.LoginCredentials;

public class LoginService {
	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	public void login(LoginCredentials loginCredentials) throws SQLException, ClassNotFoundException {
//		Dbconnection dbconnection = null;
		Connection connection = Dbconnection.getConnection();
		Content content =new Content();
		Scanner sc = new Scanner(System.in);
		AppointmentService appointmentService = new AppointmentService();
		boolean check = false;
		ResultSet loginuser = null;

		ResultSet RecCheck;

		do {
			logger.info(content.username);
			loginCredentials.setUsername(sc.next());
			logger.info(content.password);
			loginCredentials.setPassword( sc.next());
			try {

				PreparedStatement pst = connection.prepareStatement("select * from patient_registration where Name=? and password=?");
				pst.setString(1, loginCredentials.getUsername());
				pst.setString(2, loginCredentials.getPassword());
				loginuser = pst.executeQuery();
				check = loginuser.next();
				if (check) {
					loginCredentials.setLoginuserid(loginuser.getInt(1));
					loginCredentials.setLoginusername(loginuser.getString(2));
					loginCredentials.setLoginuserAge(loginuser.getInt(5));
					loginCredentials.setLoginPassword(loginuser.getString(6));
					
					logger.info("Hiii " + loginuser.getString(2) + " How may i Help you " + loginCredentials.getLoginuserid());
//						bookingAppointmentImp.bookingAppointment();
					return;
				} else {
					PreparedStatement receptionCheck = connection
							.prepareStatement("select * from Receptionist where Receptionist_name=? and Password=?");
					receptionCheck.setString(1, loginCredentials.getUsername());
					receptionCheck.setString(2, loginCredentials.getPassword());
					RecCheck = receptionCheck.executeQuery();
					if (RecCheck.next()) {
						logger.info("\nWelcome Recepationist " + RecCheck.getString(2));
						appointmentService.bookingAppointment();
						return;
					}
//						else {
//							PreparedStatement pstAdmin=dbconnection.myCon.prepareStatement("select * from PAMS_Admin where Admin_Name=? and Admin_Password=?");
//							pstAdmin.setString(1, username);
//							pstAdmin.setString(2, password);
//								Admin_user=pstAdmin.executeQuery();
//							if(Admin_user.next()) {
//								logger.info("Hii Admin "+Admin_user.getString(1));
//								adminlogedin.AdminPage();	
//								return;
//							}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (!check);
		sc.close();

	}
}
