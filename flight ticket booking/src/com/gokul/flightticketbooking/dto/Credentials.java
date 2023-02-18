package com.gokul.flightticketbooking.dto;

public class Credentials extends Admin{
	private String password;

	public Credentials(String userId, String userName, String password) {
		super.setUserId(userId);
		super.setUserName(userName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
