/**
 * 
 */
package com.revature.pams.dao;

import java.sql.SQLException;

/**
 * @author eegar
 *
 */
public interface PamsMain {

	public  void bookingAppointment() throws SQLException;
	public void Patient_Register() throws SQLException, ClassNotFoundException;
	
}
