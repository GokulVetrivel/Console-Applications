package com.gokul.bankingapplication.login;

public interface LoginControllerViewCallBack {

	int validateChoice(String choice);

	void isCustomer(int customerId_v, String password);

	void isAdmin(String adminId, String password);

}
