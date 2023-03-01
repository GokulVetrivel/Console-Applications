package com.gokul.bankingapplication.login;

import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.Customer;

public interface LoginControllerModelCallBack {

	void adminLoginSuccess(Admin admin);

	void adminLoginFailureMsg(String string);

	void customerLoginSuccess(Customer customer);

	void customerLoginFailureMsg(String string);

}
