/**
 * 
 */
package com.revature.pams.model;



/**
 * @author eegar
 *
 */
public class PatientRegistration {
	private String PatientName;
	private String PatientEmail;
	private String PatientPhone;
	private byte PatientAge;
	private String PatientPassword ;
	private String PatientRetypePassword;
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getPatientEmail() {
		return PatientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		PatientEmail = patientEmail;
	}
	public String getPatientPhone() {
		return PatientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		PatientPhone = patientPhone;
	}
	public byte getPatientAge() {
		return PatientAge;
	}
	public void setPatientAge(byte patientAge) {
		PatientAge = patientAge;
	}
	public String getPatientPassword() {
		return PatientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		PatientPassword = patientPassword;
	}
	public String getPatientRetypePassword() {
		return PatientRetypePassword;
	}
	public void setPatientRetypePassword(String patientRetypePassword) {
		PatientRetypePassword = patientRetypePassword;
	}
	
}
