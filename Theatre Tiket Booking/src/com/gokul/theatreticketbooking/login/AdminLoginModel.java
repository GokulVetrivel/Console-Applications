package com.gokul.theatreticketbooking.login;

import com.gokul.theatreticketbooking.dto.Admin;
import com.gokul.theatreticketbooking.repository.TheatreRepository;

public class AdminLoginModel implements AdminLoginModelCallBack {
	private AdminLoginControllerModelCallBack adminLoginController;
	public AdminLoginModel(AdminLoginController adminLoginController) {
		this.adminLoginController=adminLoginController;
	}
	public void checkForLogin(String userName, String password) {
		Admin user=TheatreRepository.getInstance().checkForLogin(userName,password);
		if(user!=null) {
			
			adminLoginController.successLoginMsg(user);
		}
		else adminLoginController.failedLoginMsg();
	}

}
