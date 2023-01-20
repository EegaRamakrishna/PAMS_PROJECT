package com.revature.pams.util;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.revature.pams.model.BookingPatientAppointment;


public class DateTime {
	
	static BookingPatientAppointment bookingPatientAppointemnt=new BookingPatientAppointment();
	public DateTimeFormatter Time=DateTimeFormatter.ofPattern("HH:mm:ss");
	public DateTimeFormatter Date=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	public LocalDateTime now=LocalDateTime.now();
	
	
	
	public static java.sql.Date getDate(int inDaya){
	       java.sql.Date now=new java.sql.Date(new java.util.Date().getTime());
	       return new java.sql.Date(now.getTime()+inDaya*24*60*60*1000);
	    }  
	
//	public void dateTime() {
//		
//		System.out.println(Time.format(now));
//		System.out.println(Date.format(now));
//		
//	}

}
