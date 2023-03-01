package com.gokul.bankingapplication.customer;

import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.repository.BankingRepository;

public class CustomerModel implements CustomerModelCallBack {
	private CustomerControllerModelCallBack customerController;

	public CustomerModel(CustomerController customerController) {
		this.customerController = customerController;
	}

	public void deposit(int amount_v, Customer customer) {
		BankingRepository.getInstance().deposit(amount_v, customer);

	}

	public void withdraw(int amount_v, Customer customer) {
		if (customer.getBalance() > amount_v)
			BankingRepository.getInstance().withdraw(amount_v, customer);
		else
			customerController.noSufficientBalanceMsg("you don't have sufficient balance");
	}

	public void transfer(int amount_v, Customer customer, int payeeAccountNo_v) {
		Customer customerinstance = null;
		if (customer.getBalance() > amount_v) {
			customerinstance = BankingRepository.getInstance().transfer(amount_v, customer, payeeAccountNo_v);
			if (customerinstance == null) {
				customerController.payeeAccountNotExitMsg("payee account number is not existing...");
			} else
				BankingRepository.getInstance().withdraw(amount_v, customer);
		} else
			customerController.noSufficientBalanceMsg("you don't have sufficient balance");

	}

}
