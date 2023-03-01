package com.gokul.bankingapplication.dto;

public class CustomerCredentials extends Customer{
	
	private String password;
	
	public CustomerCredentials(int accountNo, String name, int customerId, String eMail, String contactNo,String password) {
		super(accountNo, name, customerId, eMail, contactNo);
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
