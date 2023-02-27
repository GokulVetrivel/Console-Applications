package com.gokul.theatreticketbooking.login;

import com.gokul.theatreticketbooking.dto.Admin;

public class AdminLoginController implements AdminLoginControllerModelCallBack, AdminLoginControllerViewCallBack {
	private AdminLoginViewCallBack adminLoginView;
	private AdminLoginModelCallBack adminLoginModel;
	public AdminLoginController(AdminLoginView adminLoginView) {
		this.adminLoginView=adminLoginView;
		adminLoginModel=new AdminLoginModel(this);
	}
	public void checkForLogin(String userName, String password) {
		adminLoginModel.checkForLogin(userName,password);
		
	}
	public void successLoginMsg(Admin user) {
		adminLoginView.successLoginMsg(user);
	}
	public void failedLoginMsg() {
		adminLoginView.failedLoginMsg();
		
	}
	

}
