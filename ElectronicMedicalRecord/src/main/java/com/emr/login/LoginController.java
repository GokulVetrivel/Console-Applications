package com.emr.login;

public class LoginController {
	private LoginModel loginModel;
	public LoginController(){
		loginModel=new LoginModel(this);
	}
	
}
