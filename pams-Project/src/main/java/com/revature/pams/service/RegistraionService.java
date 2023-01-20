package com.revature.pams.service;

import java.sql.Connection;

//import org.apache.commons.lang3.StringUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.revature.pams.constant.Content;

import com.revature.pams.dbconnection.Dbconnection;

import com.revature.pams.model.PatientRegistration;

public class RegistraionService extends AppointmentService {
	PatientRegistration patientRegObj = new PatientRegistration();
	
	@Override
	public void Patient_Register() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Connection connecion = Dbconnection.getConnection();
		Content content = new Content();

//	    	Non important varibles
		String pemail;
		int count = 0;

		System.out.println(content.P_Name);
		patientRegObj.setPatientName(StringUtils.capitalize(sc.next()));

		do {
			System.out.println(content.P_Email);
			pemail = sc.next();
			if (pemail.contains("@")) {
				patientRegObj.setPatientEmail(pemail);
			} else {
				System.out.println("enter mail correctly?????");
				System.out.println(content.P_Email);
				pemail = sc.next();
				patientRegObj.setPatientEmail(pemail);
			}
		} while (!pemail.contains("@"));

//	    	Patient Phone Number
		System.out.println(content.P_Phone);
		patientRegObj.setPatientPhone(sc.next());

//	    	Patient age
		System.out.println(content.P_Age);
		patientRegObj.setPatientAge(sc.nextByte());

//	    	Patient password
		do {
			if (count == 0) {
				System.out.println(content.P_Password);
				patientRegObj.setPatientPassword(sc.next());
				System.out.println(patientRegObj.getPatientPassword());
				System.out.println(content.P_Retype_Password);
				patientRegObj.setPatientRetypePassword(sc.next());
				System.out.println(patientRegObj.getPatientRetypePassword());
			}
			if (count <= 1) {
				System.out.println("Count : " + count);
				System.out.println(content.password_not_match);
				System.out.println(content.P_Password);
				patientRegObj.setPatientPassword(sc.next());
				System.out.println(content.P_Retype_Password);
				patientRegObj.setPatientRetypePassword(sc.next());
			}
			count++;
		} while (!patientRegObj.getPatientPassword().equals(patientRegObj.getPatientRetypePassword()));

		String PatientRegistraionQuery = "insert into Patient_Registration(Name,email,phone,Age,password)  values(?,?,?,?,?)";
		try {
			PreparedStatement pst = connecion.prepareStatement(PatientRegistraionQuery);
			pst.setString(1, patientRegObj.getPatientName());
			pst.setString(2, patientRegObj.getPatientEmail());
			pst.setString(3, patientRegObj.getPatientPhone());
			pst.setInt(4, patientRegObj.getPatientAge());
			pst.setString(5, patientRegObj.getPatientPassword());

			int PatientReginstQuery = pst.executeUpdate();
			if (PatientReginstQuery > 0) {
				System.out.println(content.succesfully_Registerd);
			} else
				System.out.println(content.password_not_match);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}


}
