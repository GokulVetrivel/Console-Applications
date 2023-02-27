package com.gokul.coursemanagement.login;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.User;
import com.gokul.coursemanagement.repository.CourseManagementRepository;

public class LoginModel implements LoginModelCallBack {

	private LoginControllerModelCallBack loginController;

	public LoginModel(LoginController loginController) {
		this.loginController = loginController;
	}

	public void isValidAdmin(String adminId, String password) {
		Admin admin = CourseManagementRepository.getInstance().isValidAdmin(adminId, password);
		if (admin != null)
			loginController.adminLoginSuccessMsg(admin);
		else
			loginController.adminLoginFailureMsg("Credentials are not matching...! try again...");
	}

	public void isValidTrainer(String trainerId, String password) {
		Trainer trainer = CourseManagementRepository.getInstance().isValidTrainer(trainerId, password);
		if (trainer != null)
			loginController.trainerLoginSuccessMsg(trainer);
		else
			loginController.trainerLoginFailureMsg("Credentials are not matching...! try again...");
	}

	public void addUser(String userName, String emailId, String password, String phoneNumber) {
		User currUser = CourseManagementRepository.getInstance().addUser(userName, emailId, password, phoneNumber);
		if (currUser != null) {
			loginController.userAddedSuccessMsg(
					"Welcome, " + currUser.getUserName() + "\nyour account has been created successfully...");
		} else {
			loginController.existingUserNameMsg("User name already exit. Kindly login...");
		}
	}

	public void isValidUser(String userName, String password) {
		User user = CourseManagementRepository.getInstance().isValidUser(userName, password);
		if (user != null)
			loginController.userLoginSucccesMsg(user);
		else
			loginController.userLoginFailueMsg("credentials not matching....");
	}

}
