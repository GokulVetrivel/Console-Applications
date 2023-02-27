package com.gokul.coursemanagement.dto;

import java.util.List;

public class UserCredentials extends User{
	
	private String password;
	
	public UserCredentials(String userName, String emailId, String phoneNumber,
		 String password) {
		super(userName, emailId, phoneNumber);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
