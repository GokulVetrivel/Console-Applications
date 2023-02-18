package com.gokul.flightticketbooking.login;

import com.gokul.flightticketbooking.dto.Admin;

public class LoginController implements LoginControllerViewCallBack, LoginControllerModelCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}

	/**
	 * the method is validating the admin
	 * 
	 * @param userName
	 * @param password
	 */
	public void checkCredentials(String userName, String password) {
		loginModel.checkCredentials(userName, password);
		
	}

	public void loginSuccess(Admin adminUser) {
		loginView.loginSuccess(adminUser);

	}

	public void loginFailiure(String errMessage) {
		loginView.loginFailed(errMessage);

	}

}
