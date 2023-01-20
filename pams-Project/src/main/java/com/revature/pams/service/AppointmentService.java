
package com.revature.pams.service;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.revature.pams.constant.Content;

import com.revature.pams.dbconnection.Dbconnection;
import com.revature.pams.model.BookingPatientAppointment;

import com.revature.pams.util.DateTime;

public class AppointmentService extends BookingPatientAppointment {
	private static final Logger logger = Logger.getLogger(AppointmentService.class);
	public int bookingAppointmentSlotNum;
	public PreparedStatement appointmentBookingStm;
	public ResultSet doctorDetails;
	public int bookingAppoinInsert;
	public static int pID;
	public static String pName;
	public static int pAge;
	public static String patientPhonenumber;
	public ResultSet doctorBook;
	
	@Override
	public void bookingAppointment() throws SQLException {

		char isnot;
		Connection connection = null;
		Statement statement=null;
		connection = Dbconnection.getConnection();
		statement=connection.createStatement();

		AppointmentService bookingAppointmentImpobj = new AppointmentService();
		BookingPatientAppointment bookingPatientaAppointment = new BookingPatientAppointment();
		Receptionist receptionist = new Receptionist();
		try {
			receptionist.receptionist();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Content content = new Content();
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println(content.PatientLoginMenu);

			switch (sc.nextInt()) {
			case 1:

				ResultSet Patientlist = statement.executeQuery("select * from patient_registration;");
				logger.info(String.format("%-4s %-12s %-20s %-12s %-18s","ID","Name","Email","Phone","AGE"));
				while (Patientlist.next()) {
					logger.info(String.format("%-4s %-12s %-20s %-12s %-18s",Patientlist.getString(1), Patientlist.getString(2),
							 Patientlist.getString(3),Patientlist.getString(4), Patientlist.getString(5)));
					System.out.println();
				}

				System.out.println(content.pID);
				bookingPatientaAppointment.setPatientID(sc.nextInt());
				ResultSet patientIdSelect = statement
						.executeQuery("select patient_id,name,age,phone from patient_registration where Patient_id="
								+ bookingPatientaAppointment.getPatientID());

				while (patientIdSelect.next()) {
					pID = patientIdSelect.getInt(1);
					pName = patientIdSelect.getString(2);
					pAge = patientIdSelect.getInt(3);
					patientPhonenumber=patientIdSelect.getString(4);
					
//					System.out.format("%-4s %-18s %6s %8s %-12s %-18s",patientIdSelect.getInt(1) + " " + patientIdSelect.getString(2) + " "
//							+ patientIdSelect.getInt(3)+" "+patientIdSelect.getString(4));
				}
				String appointmentBookingQuery = "insert into Book_Appointment(Patient_ID,Patient_Name,Patient_Age,patient_mobileNumber,"
						+ "Patient_Gender,Patient_Address,Patient_Appointment_date,"
						+ "Patient_Preferred_Time_slot,Patient_Ailment_Symptoms,Doctor_Name,Doctor_Fee,Status) values(?,?,?,?,?,?,?,?,?,?,?,?);";
				try {
					bookingAppointmentImpobj.appointmentBookingStm = connection.prepareStatement(appointmentBookingQuery);
				} catch (SQLException e1) {
					logger.error(e1);
				}
//				System.out.println("welcome for Appointment booking\nHi "+loginuser.login_user_name+" I am "+receptionist.receptionistname+" i will book Your Appointement");

				System.out.println(content.p_gender);
				int patientgenderass = sc.nextInt();

				if (patientgenderass == 1)
					bookingPatientaAppointment.setPatientgender('M');
				else if (patientgenderass == 2)
					bookingPatientaAppointment.setPatientgender('F');
				else
					bookingPatientaAppointment.setPatientgender('O');

				System.out.println(content.p_Address);
				bookingPatientaAppointment.setPatientaddress(sc.next());
				System.out.println(content.p_Appointment_Date);
				int dateinDays = sc.nextInt();
				bookingPatientaAppointment.setPatientAppointmentDateindays(DateTime.getDate(dateinDays));
				System.out.println(bookingPatientaAppointment.getPatientAppointmentDateindays());
				System.out.println(content.P_Preferred_Time_slotstm);
				System.out.println(content.P_Preferred_Time_slot);
				bookingAppointmentSlotNum = sc.nextInt();
				bookingPatientaAppointment.timeSlotcheck(bookingAppointmentSlotNum);
				System.out.println(bookingPatientaAppointment.patientAppointmentSlot);
				System.out.println(content.p_Ailment_Symptoms);
				bookingPatientaAppointment.setPatientAilmentSymptoms(sc.next());

				System.out.println(content.paDoctorName);

				try {
					doctorBook = statement.executeQuery("select * from DOCTOR_RECORD;");
				} catch (SQLException e) {
					logger.error(e);
				}
				try {
					logger.info(String.format("%-4s %-18s %10s %-10s %-12s %18s","ID","NAME","Experience","   Fee","SPECIALITY","SPECIALITY"));
					while (doctorBook.next()) {
						try {
							logger.info(String.format("%-4s %-18s %10s %-10s %-12s %18s",doctorBook.getString(1),doctorBook.getString(2),
									doctorBook.getString(3),doctorBook.getString(4),
									 doctorBook.getString(5),doctorBook.getString(6)));
							System.out.println();
						} catch (SQLException e) {
							logger.error(e);
						}
					}
				} catch (SQLException e) {
					logger.error(e);
				}

				System.out.print(content.selectDoctorId);
				int docId = sc.nextInt();

				try {
					ResultSet docIdDb = statement
							.executeQuery("select DOCTOR_NAME,CONSULTING_CHARGE from DOCTOR_RECORD where DOCTOR_ID=" + docId);
					while (docIdDb.next()) {
						bookingPatientaAppointment.setDoctorName(docIdDb.getString(1));
						bookingPatientaAppointment.setDoctorFee(docIdDb.getInt(2));
						
					}
				} catch (SQLException e) {

					logger.error(e);
				}

				try {
					bookingAppointmentImpobj.appointmentBookingStm.setInt(1, AppointmentService.pID);
					bookingAppointmentImpobj.appointmentBookingStm.setString(2, AppointmentService.pName);
					bookingAppointmentImpobj.appointmentBookingStm.setInt(3, AppointmentService.pAge);
					bookingAppointmentImpobj.appointmentBookingStm.setString(4, AppointmentService.patientPhonenumber);
					bookingAppointmentImpobj.appointmentBookingStm.setString(5,String.valueOf(bookingPatientaAppointment.getPatientgender()));
					bookingAppointmentImpobj.appointmentBookingStm.setString(6,bookingPatientaAppointment.getPatientaddress());
					bookingAppointmentImpobj.appointmentBookingStm.setDate(7,(Date) bookingPatientaAppointment.getPatientAppointmentDateindays());
					bookingAppointmentImpobj.appointmentBookingStm.setString(8,bookingPatientaAppointment.patientAppointmentSlot);
					bookingAppointmentImpobj.appointmentBookingStm.setString(9,bookingPatientaAppointment.getPatientAilmentSymptoms());
					bookingAppointmentImpobj.appointmentBookingStm.setString(10,bookingPatientaAppointment.getDoctorName());
					bookingAppointmentImpobj.appointmentBookingStm.setInt(11,bookingPatientaAppointment.getDoctorFee());
					bookingAppointmentImpobj.appointmentBookingStm.setString(12, "Conformed");

				} catch (SQLException e) {
					logger.error(e);
				}
				String docAvlCheck = "select patient_Appointment_date,patient_preferred_time_slot,Doctor_Name"
						+ " from book_appointment where patient_Appointment_date= '"
						+ bookingPatientaAppointment.getPatientAppointmentDateindays() + "'"
						+ " && patient_preferred_time_slot=" + '"' + bookingPatientaAppointment.patientAppointmentSlot
						+ '"' + " and Doctor_Name='" + bookingPatientaAppointment.getDoctorName() + "'";



				ResultSet checkAvil = statement.executeQuery(docAvlCheck);

				int count = 0;

				while (checkAvil.next()) {

					System.out.println(checkAvil.getString(1) + "  " + checkAvil.getString(2));
					count++;

				}

				if (count == 0) {
					bookingAppoinInsert = bookingAppointmentImpobj.appointmentBookingStm.executeUpdate();
					if (bookingAppoinInsert == 1) {
						System.out.println("*****Booking Conformed*******");
					} else
						System.out.println("***Not Conformed****");
				} else {
					System.out.println("Slot in Not Avaible123");

				}

				System.out.println();
				System.out.println("1 : Back");
				System.out.println("2 : Exit");
				if (sc.nextInt() == 1) {
					bookingAppointment();
					break;
				}

				else if (sc.nextInt() == 2) {
					System.out.println(content.exitMessage);
					System.out.println(content.Footer);
					System.exit(0);
					return;
				}

				return;
			case 2: {
				try {
					doctorDetails = statement.executeQuery("select * from DOCTOR_RECORD;");
				} catch (SQLException e) {
					logger.error(e);
				}
				try {
					logger.info(String.format("%-4s %-18s %10s %-10s %-12s %18s","ID","NAME","Experience","   Fee","SPECIALITY","SPECIALITY"));
					System.out.println();
					while (doctorDetails.next()) {
						try {
							logger.info(String.format("%-4s %-18s %-12s %-12s %-12s %-18s",doctorDetails.getString(1),doctorDetails.getString(2),
									doctorDetails.getString(3),doctorDetails.getString(4),
									 doctorDetails.getString(5),doctorDetails.getString(6)));
							System.out.println();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					logger.error(e);
				}
				System.out.println();
				System.out.println("1 : Back");
				System.out.println("2 : Exit");
				if (sc.nextInt() == 1) {
					bookingAppointment();
					break;
				}

				else if (sc.nextInt() == 2) {
					System.out.println(content.exitMessage);
					System.out.println(content.Footer);
					System.exit(0);
					return;
				}
				return;
				}
				case 3: {
					
					String patientRegistrationList="select * from book_appointment";
					ResultSet patientCheckList = statement.executeQuery(patientRegistrationList);
					logger.info(String.format("%-4s %4s %8s %8s %8s %10s %18s %14s %18s %14s %12s %12s","ID", "Name", "Age",
							"Phone", "Gender", "Address", "Appointment_date", 
							"Time_slot", "Ailment_Symptoms", "Doctor_Name", "Doctor_fee", "Status"));
					System.out.println();
					while(patientCheckList.next()) {
						logger.info(String.format("%-4s %4s %8s %8s %8s %10s %18s %14s %18s %14s %12s %12s",patientCheckList.getInt(1),patientCheckList.getString(2)
						,patientCheckList.getInt(3),patientCheckList.getString(4),patientCheckList.getString(5),patientCheckList.getString(6),patientCheckList.getString(7),
								patientCheckList.getString(8),patientCheckList.getString(9),
								patientCheckList.getString(10),patientCheckList.getInt(11),patientCheckList.getString(12)));
						System.out.println();
					}
					System.out.println();
					System.out.println("1 : Back");
					System.out.println("2 : Exit");
					if (sc.nextInt() == 1) {
						bookingAppointment();
						break;
					}
					else if (sc.nextInt() == 2) {
						System.out.println(content.exitMessage);
						System.out.println(content.Footer);
						System.exit(-1);
						return;
					}
					break;
					
				}
				case 4:{
					sc.close();
					System.exit(0);
				}
				default:{
					logger.info(content.defaultS);
				}
			}
			System.out.println("\nDO you Want to continue  (Y/N) :");
			isnot = sc.next().toUpperCase().charAt(0);
			if (isnot == 'N') {
				System.out.println(content.exitMessage);
				System.exit(1);
			} else if (isnot == 'Y') {
				bookingAppointment();
			}
			
		} while (isnot == 'Y');
	}
}
