package com.emr.login;

import com.emr.dto.Clinic;
import com.emr.repository.Repository;

public class LoginModel {
	private LoginController loginController;

	public LoginModel(LoginController loginController) {
		this.loginController = loginController;
	}
	public LoginModel() {}
//	public static void main(String[] args) {
//	boolean b=	addClinic("gokul Clinic","52, mayavan street,cheenai 600028","9871237878","gokul@gmail.com","Gokul123");
//	System.out.println(b);
//	}
	public Clinic isClinic(String clinicName, String password) {
		return Repository.getInstance().isClinic(clinicName, password);
	}
	
	public boolean addClinic(String clinicName, String Address, String clinicPhoneNo, String eMailId, String password) {
		return Repository.getInstance().addClinic(clinicName, Address, clinicPhoneNo, eMailId, password);
		
	}
}
