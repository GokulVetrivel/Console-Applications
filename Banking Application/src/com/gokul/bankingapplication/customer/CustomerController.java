package com.gokul.bankingapplication.customer;

import com.gokul.bankingapplication.dto.Customer;

public class CustomerController implements CustomerControllerViewCallBack, CustomerControllerModelCallBack {
	private CustomerViewCalBack customerView;
	private CustomerModelCallBack customerModel;

	public CustomerController(CustomerView customerView) {
		this.customerView = customerView;
		this.customerModel = new CustomerModel(this);
	}

	public void deposit(int amount_v, Customer customer) {
		customerModel.deposit(amount_v, customer);
	}

	public void withdraw(int amount_v, Customer customer) {
		customerModel.withdraw(amount_v, customer);

	}

	public void noSufficientBalanceMsg(String msg) {
		customerView.noSufficientBalanceMsg(msg);

	}

	public void transfer(int amount_v, Customer customer, int payeeAccountNo_v) {
		customerModel.transfer(amount_v, customer, payeeAccountNo_v);
	}

	public void payeeAccountNotExitMsg(String msg) {
		customerView.payeeAccountNotExitMsg(msg);
	}

}
