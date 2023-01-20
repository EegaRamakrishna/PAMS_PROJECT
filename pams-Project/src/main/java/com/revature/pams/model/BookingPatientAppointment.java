/**
 * 
 */
package com.revature.pams.model;


import java.sql.SQLException;
import java.util.Date;

import com.revature.pams.dao.PamsMain;

/**
 * @author eegar
 *
 */
public class BookingPatientAppointment implements PamsMain{
	
	public int patientID;

	public String patientAppointmentSlot;
	private  char patientgender;
	private  String patientaddress;
	private  Date patientAppointmentDateindays;
	private  String patientAilmentSymptoms;
	private String doctorName;
	private int doctorFee;
	
	
	
	

	public int getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(int doctorFee) {
		this.doctorFee = doctorFee;
	}

	public int getPatientID() {
		return patientID;
	}
	
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}


	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public char getPatientgender() {
		return patientgender;
	}
	
	public void setPatientgender(char patientgender) {
		this.patientgender = patientgender;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	
	public String getPatientAilmentSymptoms() {
		return patientAilmentSymptoms;
	}
	

	public Date getPatientAppointmentDateindays() {
		return patientAppointmentDateindays;
	}

	public void setPatientAppointmentDateindays(Date patientAppointmentDateindays) {
		this.patientAppointmentDateindays = patientAppointmentDateindays;
	}

	public void setPatientAilmentSymptoms(String patientAilmentSymptoms) {
		this.patientAilmentSymptoms = patientAilmentSymptoms;
	}
	
	public void timeSlotcheck(int timeslotmenuoption) {
		
		switch (timeslotmenuoption) {
			case 1:
				patientAppointmentSlot="'9:30AM'";
				break;
			case 2:
				patientAppointmentSlot="'10:00AM'";
				break;
			case 3:
				patientAppointmentSlot="'10:30AM'";
				break;
			case 4:
				patientAppointmentSlot="'11:00AM'";
				break;
			case 5:
				patientAppointmentSlot="'11:30AM'";
				break;
			case 6:
				patientAppointmentSlot="'12:00AM'";
				break;
			case 7:
				patientAppointmentSlot="'12:30PM'";
				break;
			case 8:
				patientAppointmentSlot="'01:00PM'";
				break;
		}
	}

	@Override
	public void bookingAppointment() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Patient_Register() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	

}
