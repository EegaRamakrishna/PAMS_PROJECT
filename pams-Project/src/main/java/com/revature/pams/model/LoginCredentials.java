package com.revature.pams.model;

public class LoginCredentials {

/**
	 * 
	 */
	public LoginCredentials() {
		super();
	}
/**
	 * @param username
	 * @param password
	 */
//	public LoginCredentials(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//	}
		//	public void LoginCredentials() {
		private String loginusername;
		 private int loginuserid;
		private int loginuserAge;
		private String username;
		private String password;
		private String loginPassword;
		
		public String getLoginPassword() {
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLoginusername() {
			return loginusername;
		}
		public void setLoginusername(String loginusername) {
			this.loginusername = loginusername;
		}
		public int getLoginuserid() {
			return loginuserid;
		}
		public void setLoginuserid(int loginuserid) {
			this.loginuserid = loginuserid;
		}
		public int getLoginuserAge() {
			return loginuserAge;
		}
		public void setLoginuserAge(int loginuserAge) {
			this.loginuserAge = loginuserAge;
		}

//	}
}
