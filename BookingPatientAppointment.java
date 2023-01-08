/**
 * 
 */
package com.model;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author eegar
 *
 */
public class BookingPatientAppointment {
	
	private String p_Name ;
	private int age;
	private char Gender;
	private String Contact_No;
	private String Address;
	private Date Appointment_Date;
	public BookingPatientAppointment(String p_Name, int age, char gender, String contact_No, String address,
			Date appointment_Date, LocalTime preferred_Time_slot, String ailment_Symptoms, String doctor_Name,
			String status) {
		super();
		this.p_Name = p_Name;
		this.age = age;
		Gender = gender;
		Contact_No = contact_No;
		Address = address;
		Appointment_Date = appointment_Date;
		Preferred_Time_slot = preferred_Time_slot;
		Ailment_Symptoms = ailment_Symptoms;
		Doctor_Name = doctor_Name;
		Status = status;
	}
	
	
	private LocalTime Preferred_Time_slot;
	private String Ailment_Symptoms;
	private String Doctor_Name;
	private String Status;
	
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public String getContact_No() {
		return Contact_No;
	}
	public void setContact_No(String contact_No) {
		Contact_No = contact_No;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Date getAppointment_Date() {
		return Appointment_Date;
	}
	public void setAppointment_Date(Date appointment_Date) {
		Appointment_Date = appointment_Date;
	}
	public LocalTime getPreferred_Time_slot() {
		return Preferred_Time_slot;
	}
	public void setPreferred_Time_slot(LocalTime preferred_Time_slot) {
		Preferred_Time_slot = preferred_Time_slot;
	}
	public String getAilment_Symptoms() {
		return Ailment_Symptoms;
	}
	public void setAilment_Symptoms(String ailment_Symptoms) {
		Ailment_Symptoms = ailment_Symptoms;
	}
	public String getDoctor_Name() {
		return Doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	 
	

}
