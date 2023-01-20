package com.revature.pams.app;

import java.sql.SQLException;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.pams.constant.Content;
import com.revature.pams.model.LoginCredentials;
import com.revature.pams.service.*;

public class Pams extends Thread
{
	static Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(AppointmentService.class);


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Content content = new Content();
		RegistraionService paRegistraion = new RegistraionService();
		LoginService paLogin = new LoginService();
		Pams pams=new Pams();
		pams.start();

		char Isnot;
		do {
			System.out.println(content.header);
			System.out.print(content.Index_Page);
			switch (sc.nextInt()) {
			case 1:
				paRegistraion.Patient_Register();
				break;
			case 2:
				paLogin.login(new LoginCredentials());
//					receptionistobj.receptionist();
				break;
			default:
				logger.info(content.defaultS);
			}
			System.out.println("\nDO you Want to continue  (Y/N) :");
			Isnot = sc.next().toUpperCase().charAt(0);
			if (Isnot == 'N') {
				System.out.println("I am there For You..\nBye Bye...");
				System.exit(0);
			}
			
		} while (Isnot == 'Y');

	}

}
