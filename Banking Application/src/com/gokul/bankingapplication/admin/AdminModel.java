package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.repository.BankingRepository;

public class AdminModel implements AdminModelCallBack {
	private AdminControllerModelCallBack adminController;

	public AdminModel(AdminController adminController) {
		this.adminController = adminController;
	}

	public void addCustomer(String name, String eMail, String contactNo, String password) {
		Customer customer=BankingRepository.getInstance().addCustomer(name, eMail, contactNo, password);
		adminController.customerAddedMsg(customer);
	}

	public Customer getCustomer(int customerId) {
		Customer customer= BankingRepository.getInstance().getCustomer(customerId);
		if(customer==null) {
			adminController.customerNotFoundmsg("customer doesn't exist...");
		}
		return customer;
		
	}
}
