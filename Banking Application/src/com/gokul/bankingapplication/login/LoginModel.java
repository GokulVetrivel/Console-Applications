package com.gokul.bankingapplication.login;

import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.repository.BankingRepository;

public class LoginModel implements LoginModelCallBack {
	private LoginControllerModelCallBack loginController;

	public LoginModel(LoginController loginController) {
		this.loginController = loginController;
	}

	public void isAdmin(String adminId, String password) {
		Admin admin = BankingRepository.getInstance().isAdmin(adminId, password);
		if (admin != null)
			loginController.adminLoginSuccess(admin);
		else
			loginController.adminLoginFailureMsg("creentials are not matching...");
	}

	public void isCustomer(int customerId, String password) {
		Customer customer = BankingRepository.getInstance().isCustomer(customerId, password);
		if (customer != null)
			loginController.customerLoginSuccess(customer);
		else
			loginController.customerLoginFailureMsg("credentials are not matching...");
	}

}
