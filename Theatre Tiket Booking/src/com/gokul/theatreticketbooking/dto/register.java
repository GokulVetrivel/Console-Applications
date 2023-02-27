package com.gokul.theatreticketbooking.dto;

public class register {
	private String eMailLoginId;
	private String password;
	private String mobileNo;
	private String city;
	public String geteMailLoginId() {
		return eMailLoginId;
	}
	public void seteMailLoginId(String eMailLoginId) {
		this.eMailLoginId = eMailLoginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
