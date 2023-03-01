package com.gokul.bankingapplication.dto;

public class Customer {
	
	private int accountNumber;
	private String name;
	private int customerId;
	private String eMail;
	private String contactNo;
	private double balance;
	
	
	public Customer() {}
	public Customer(int accountNo, String name,int customerId, String eMail, String contactNo) {
		super();
		this.accountNumber = accountNo;
		this.name = name;
		this.customerId = customerId;
		this.eMail = eMail;
		this.contactNo = contactNo;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
