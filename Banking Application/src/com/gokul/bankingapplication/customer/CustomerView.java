package com.gokul.bankingapplication.customer;

import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.util.GetInput;

public class CustomerView implements CustomerViewCalBack {
	private CustomerControllerViewCallBack customerController;

	public CustomerView() {
		customerController = new CustomerController(this);
	}

	public void create(Customer customer) {
		CustomerView customerView = new CustomerView();
		customerView.customerMenu(customer);
	}

	private void customerMenu(Customer customer) {
		System.out.println("-----> Customer menu <-----\n");
		boolean askAgain = true;
		do {
			System.out.println("1.View profile\n2.Deposit\n3.Withdrow\n4.Transfer\n9.Back");
			System.out.print("Enter your choice :");
			String choice = GetInput.getString();
			int choice_v = 0;
			try {
				choice_v = Integer.parseInt(choice);
			} catch (Exception e) {
				System.out.println("choose valid option...");
			}
			switch (choice_v) {

			case 1:
				showProfile(customer);
				break;

			case 2:
				deposit(customer);
				break;

			case 3:
				withdraw(customer);
				break;

			case 4:
				transfer(customer);
				break;

			case 9:
				askAgain = false;
				break;

			default:
				System.err.println("enter valid option");

			}
		} while (askAgain);

	}

	private void showProfile(Customer customer) {
		System.out.println("Customer Name :" + customer.getName() + "\nAccount Number :" + customer.getAccountNumber()
				+ "\nemail :" + customer.geteMail() + "\nphone number :" + customer.getContactNo() + "\nBalance :"
				+ customer.getBalance());

	}

	private void deposit(Customer customer) {
		System.out.print("amount :");
		String amount = GetInput.getString();
		int amount_v = 0;
		try {
			amount_v = Integer.parseInt(amount);
		} catch (Exception e) {
			System.out.println("choose valid option...");
			customerMenu(customer);
		}
		customerController.deposit(amount_v, customer);
		System.out.println("avalable amount :" + customer.getBalance());
	}

	private void withdraw(Customer customer) {
		System.out.print("amount :");
		String amount = GetInput.getString();
		int amount_v = 0;
		try {
			amount_v = Integer.parseInt(amount);
		} catch (Exception e) {
			System.out.println("choose valid option...");
			customerMenu(customer);
		}
		customerController.withdraw(amount_v, customer);
		System.out.println("avalable amount :" + customer.getBalance());

	}

	private void transfer(Customer customer) {
		System.out.print("amount :");
		String amount = GetInput.getString();
		int amount_v = 0;
		try {
			amount_v = Integer.parseInt(amount);
		} catch (Exception e) {
			System.err.println("Enter valid amount...");
			customerMenu(customer);
		}
		System.out.print("payee account number :");
		String payeeAccountNo = GetInput.getString();
		int payeeAccountNo_v = 0;
		try {
			payeeAccountNo_v = Integer.parseInt(payeeAccountNo);
		} catch (Exception e) {
			System.err.println("Enter valid account Number...");
			customerMenu(customer);
		}
		customerController.transfer(amount_v, customer, payeeAccountNo_v);
		System.out.println("avalable amount :" + customer.getBalance());

	}

	public void noSufficientBalanceMsg(String msg) {
		System.err.println(msg);

	}

	public void payeeAccountNotExitMsg(String msg) {
		System.err.println(msg);

	}

}
