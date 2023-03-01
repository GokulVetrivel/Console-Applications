package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;

public interface AdminControllerViewCallBack {

	int validateChoice(String choice);

	Customer getCustomer(int customerId);

	void addCustomer(String name, String eMail, String contactNo, String password);

}
