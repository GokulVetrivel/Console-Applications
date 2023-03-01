package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;

public class AdminController implements AdminControllerViewCallBack, AdminControllerModelCallBack {

	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;

	public AdminController(AdminView adminView) {
		this.adminView = adminView;
		adminModel = new AdminModel(this);
	}

	public int validateChoice(String choice) {
		int choice_v = 0;
		try {
			choice_v = Integer.parseInt(choice);
		} catch (Exception e) {
			adminView.choiceErrorMsg("invalid choice ...");
		}
		return choice_v;
	}

	public void addCustomer(String name, String eMail, String contactNo, String password) {
		adminModel.addCustomer(name, eMail, contactNo, password);

	}

	public void customerAddedMsg(Customer customer) {
		adminView.customerAddedMsg(customer);

	}

	public Customer getCustomer(int customerId) {
		return adminModel.getCustomer(customerId);

	}

	public void customerNotFoundmsg(String msg) {
		adminView.customerNotFoundmsg(msg);
	}

}
