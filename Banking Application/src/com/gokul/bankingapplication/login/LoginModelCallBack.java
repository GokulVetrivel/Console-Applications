package com.gokul.bankingapplication.login;

public interface LoginModelCallBack {

	void isAdmin(String adminId, String password);

	void isCustomer(int customerId, String password);

}
