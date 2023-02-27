package com.gokul.theatreticketbooking.dto;

public class Credentials extends Admin{
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Credentials(String userId,String userName,String password){
		super.setUserName(userName);
		super.setUserId(userId);
		this.password=password;
	}
}
