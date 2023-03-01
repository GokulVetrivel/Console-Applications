package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;

public interface AdminModelCallBack {

	void addCustomer(String name, String eMail, String contactNo, String password);

	Customer getCustomer(int customerId);

}
