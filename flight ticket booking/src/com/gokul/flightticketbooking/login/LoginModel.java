package com.gokul.flightticketbooking.login;

import com.gokul.flightticketbooking.dto.Admin;
import com.gokul.flightticketbooking.repository.BookingRepository;

public class LoginModel implements LoginModelCallBack {
	private LoginControllerModelCallBack loginController;
	
	public LoginModel(LoginController loginController) {
		this.loginController=loginController;
	}

	public void checkCredentials(String userName, String password) {
		boolean canLogin = false;
		Admin adminUser = BookingRepository.getInstance().checkValidUser(userName,password);
		if (adminUser !=null) {
			loginController.loginSuccess(adminUser);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}
	}

}
