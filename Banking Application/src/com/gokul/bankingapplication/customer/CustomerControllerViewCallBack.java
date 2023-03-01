package com.gokul.bankingapplication.customer;

import com.gokul.bankingapplication.dto.Customer;

public interface CustomerControllerViewCallBack {

	void deposit(int amount_v, Customer customer);

	void withdraw(int amount_v, Customer customer);

	void transfer(int amount_v, Customer customer, int payeeAccountNo_v);

}
