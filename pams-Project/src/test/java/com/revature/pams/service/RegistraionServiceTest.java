package com.revature.pams.service;


import java.sql.SQLException;


public class RegistraionServiceTest extends AppointmentService {
	
	public void registraionServiceTest() throws ClassNotFoundException, SQLException {
		RegistraionService registraionServiceobj=new RegistraionService();
		registraionServiceobj.Patient_Register();
		
		
		
	}

	}
