package com.gokul.bankingapplication.login;

import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.Customer;

public interface LoginViewCallBack {

	void choiceErrorMsg(String string);

	void adminLoginSuccess(Admin admin);

	void adminLoginFailureMsg(String msg);

	void customerLoginSuccess(Customer customer);

	void customerLoginFailureMsg(String msg);

}
