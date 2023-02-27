package com.gokul.coursemanagement.login;

public interface LoginControllerViewCallBack {

	int validateChoice(String choice);

	void isValidAdmin(String adminId, String password);

	void isValidTrainer(String trainerId, String password);

	void newStudent(String userName, String emailId, String password, String rePassword, String phoneNumber);

	void isValidUser(String userName, String password);

}
