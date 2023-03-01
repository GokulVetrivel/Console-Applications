package com.gokul.bankingapplication.login;

import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.Customer;

public class LoginController implements LoginControllerViewCallBack, LoginControllerModelCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	public LoginController(LoginView loginView) {
		this.loginView=loginView;
		loginModel=new LoginModel(this);
	}
	public int validateChoice(String choice) {
		int choice_v=0;
		try {
			choice_v=Integer.parseInt(choice);
		}
		catch(Exception e){
			loginView.choiceErrorMsg("invalid choice...");
		}
		return choice_v;
	}
	public void isAdmin(String adminId, String password) {
		loginModel.isAdmin(adminId, password);
		
	}
	public void adminLoginSuccess(Admin admin) {
		loginView.adminLoginSuccess(admin);
		
	}
	public void adminLoginFailureMsg(String msg) {
		loginView.adminLoginFailureMsg(msg);
	}
	
	//***cutomer login***//
	public void isCustomer(int customerId, String password) {
		loginModel.isCustomer(customerId, password);
		
	}
	public void customerLoginSuccess(Customer customer) {
		loginView.customerLoginSuccess(customer);
		
	}
	public void customerLoginFailureMsg(String msg) {
		loginView.customerLoginFailureMsg(msg);
	}

}
