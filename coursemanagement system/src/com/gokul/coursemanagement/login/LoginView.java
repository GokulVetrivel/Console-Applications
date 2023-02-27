package com.gokul.coursemanagement.login;

import com.gokul.coursemanagement.admin.AdminView;
import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.User;
import com.gokul.coursemanagement.trainer.TrainerView;
import com.gokul.coursemanagement.user.UserView;
import com.gokul.coursemanagement.util.GetInput;

public class LoginView implements LoginViewCallBack {
	private LoginControllerViewCallBack loginController;
	
	public LoginView() {
		this.loginController=new LoginController(this);
	}
	
	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.mainMenu();
	}

	public void mainMenu() {
		System.out.println("-----> Course Management <------");
		boolean askAgain = true;
		do {
			System.out.println("1.Admin Login \n2.Trainer Login \n3.User SignUp \n4.User Login \n5.Exit\n");
			System.out.print("Enter your choice:");
			String choice = GetInput.getChoice();
			int choice_v = loginController.validateChoice(choice);
			switch(choice_v)
			{
				case 1: adminLogin();
						  break;
				case 2: trainerLogin();
						  break;
				case 3: userSignUp();
						  break;
				case 4: userLogin();
						  break;
				case 5: askAgain = false;
						  break;
				default: System.out.println("Please enter a valid option\n");
			}
		}while(askAgain);
		System.out.println("\n------>Thank You<------\n");
	}

	private void adminLogin() {
		System.out.println("\n------>Admin Login Page<------\n");
		System.out.print("Enter Admin Id:");
		String adminId = GetInput.getId();
		System.out.print("Enter Admin Password:");
		String password = GetInput.getPassword();
		loginController.isValidAdmin(adminId, password);
	}

	private void trainerLogin() {
		System.out.println("\n------>Trainer Login Page<------\n");
		System.out.print("Enter Trainer Id:");
		String trainerId = GetInput.getId();
		System.out.print("Enter Trainer Password:");
		String password = GetInput.getPassword();
		loginController.isValidTrainer(trainerId, password);
	}

	private void userSignUp() {
		System.out.println("\n------>User SignUp Page<------\n");
		System.out.print("Enter User Name:");
		String userName = GetInput.getName(); 
		System.out.print("Enter email Id:");
		String emailId = GetInput.getEmailId();
		System.out.print("Enter User Password:");
		String password = GetInput.getPassword();
		System.out.print("ReEnter User Password:");
		String rePassword  = GetInput.getPassword();
		System.out.print("Enter your Phone Number");
		String phoneNumber = GetInput.getPhoneNumber();
		loginController.newStudent(userName, emailId, password,rePassword, phoneNumber);
	}

	private void userLogin() {
		System.out.println("\n------>User Login Page<------\n");
		System.out.print("Enter User Name:");
		String userName = GetInput.getId();
		System.out.print("Enter User Password:");
		String password = GetInput.getPassword();
		loginController.isValidUser(userName, password);
	}

	public void adminLoginSuccessMsg(Admin admin) {
		System.out.println("Welcome, "+admin.getAdminName());
		AdminView adminView = new AdminView();
		adminView.create();
	}

	public void adminLoginFailureMsg(String msg) {
		System.err.println(msg);
		adminLogin();
	}

	public void trainerLoginSuccessMsg(Trainer trainer) {
		System.out.println("Welcome, "+trainer.getTrainerName());
		TrainerView trainerView = new TrainerView();
		trainerView.create(trainer);
	}

	public void trainerLoginFailureMsg(String msg) {
		System.err.println(msg);
		trainerLogin();
	}

	public void notValidEmailMsg(String msg) {
		System.err.println(msg);
		userSignUp();
	}

	public void passwordMismatchMsg(String msg) {
		System.err.println(msg);
		userSignUp();
	}

	public void userAddedSuccessMsg(String msg) {
		System.err.println(msg);
		userLogin();
	}

	public void existingUserNameMsg(String msg) {
		System.err.println(msg);
		userSignUp();
	}

	public void userLoginSucccesMsg(User user) {
		System.out.println("Welcome, "+user.getUserName());	
		UserView userView = new UserView();
		userView.create(user);
	}

	public void userLoginFailureMsg(String msg) {
		System.out.println(msg);
		userLogin();
	}

	/*****printing validation messages from controller*****/
}
