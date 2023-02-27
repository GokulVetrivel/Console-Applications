package com.gokul.coursemanagement.login;

public interface LoginModelCallBack {

	void isValidAdmin(String adminId, String password);

	void isValidTrainer(String trainerId, String password);

	void addUser(String userName, String emailId, String password, String phoneNumber);

	void isValidUser(String userName, String password);

}
