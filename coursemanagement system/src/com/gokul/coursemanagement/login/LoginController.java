package com.gokul.coursemanagement.login;

import java.text.ParseException;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.User;

public class LoginController implements LoginControllerViewCallBack, LoginControllerModelCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	public LoginController(LoginView loginView) {
		this.loginView=loginView;
		loginModel=new LoginModel(this);
	}
	/***validating choice****/
	public int validateChoice(String choice) {
		int choice_v=0;
		try {
		choice_v = Integer.parseInt(choice);
		}
		catch(Exception e){
			System.err.println("choose valid option ...");
			loginView.mainMenu();
		}
		return choice_v;
	}
	/****validating admin *****/
	public void isValidAdmin(String adminId, String password) {
		loginModel.isValidAdmin(adminId, password);
		
	}
	public void isValidTrainer(String trainerId, String password) {
		loginModel.isValidTrainer(trainerId, password);
		
	}
	public void newStudent(String userName, String emailId, String password,String rePassword, String phoneNumber) {
		if(emailId.contains("@") && emailId.contains(".") && password.equals(rePassword))
			loginModel.addUser(userName, emailId, password, phoneNumber);
		else if(!(emailId.contains("@") && emailId.contains("."))){
			loginView.notValidEmailMsg("enter valid email Id..");
		}
		else if(!password.equals(rePassword)) {
			loginView.passwordMismatchMsg("Password mismatch...");
		}
				
	}
	public void isValidUser(String userName, String password) {
		loginModel.isValidUser(userName, password);
		
	}
	public void adminLoginSuccessMsg(Admin admin) {
		loginView.adminLoginSuccessMsg(admin);	
	}
	
	public void adminLoginFailureMsg(String msg) {
		loginView.adminLoginFailureMsg(msg);
		
	}
	public void trainerLoginSuccessMsg(Trainer trainer) {
		loginView.trainerLoginSuccessMsg(trainer);	
	}
	public void trainerLoginFailureMsg(String msg) {
		loginView.trainerLoginFailureMsg(msg);	
	}
	
	public void userAddedSuccessMsg(String msg) {
		loginView.userAddedSuccessMsg(msg);
	}
	public void existingUserNameMsg(String msg) {
		loginView.existingUserNameMsg(msg);	
	}
	
	public void userLoginSucccesMsg(User user) {
		loginView.userLoginSucccesMsg(user);	
	}
	public void userLoginFailueMsg(String msg) {
		loginView.userLoginFailureMsg(msg);
	}	

}
