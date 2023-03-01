package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.util.GetInput;

public class AdminView implements AdminViewCallBack {
	private AdminControllerViewCallBack adminController;

	public AdminView() {
		adminController = new AdminController(this);
	}

	public void create() {
		adminMenu();
	}

	private void adminMenu() {
		System.out.println("-----> Admin Page <-----");
		boolean askAgain = true;
		do {
			System.out.println("1.add customer \n2.view customer details \n9.back");
			String choice = GetInput.getString();
			int choice_v = adminController.validateChoice(choice);
			switch (choice_v) {

			case 1:
				addCustomer();
				break;

			case 2:
				getCustomer();
				break;

			case 9:
				askAgain = false;
				break;

			default:
				System.err.println("enter available options...");
			}

		} while (askAgain);
	}

	private void getCustomer() {
		System.out.println("customer id :");
		int customerId = GetInput.getInt();
		Customer customer = adminController.getCustomer(customerId);
		if (customer != null) {
			System.out.println("Customer Name :" + customer.getName() + "\nAccount Number :"
					+ customer.getAccountNumber() + "\nemail :" + customer.geteMail() + "\nphone number :"
					+ customer.getContactNo() + "\nBalance :" + customer.getBalance());
		}
	}

	private void addCustomer() {
		System.out.println("-----> customer adding page <-----\n");
		System.out.print("Customer Name :");
		String name = GetInput.getString();
		System.out.println("E mail :");
		String eMail = GetInput.getString();
		System.out.println("phone no :");
		String contactNo = GetInput.getString();
		System.out.println("password :");
		String password = GetInput.getString();

		adminController.addCustomer(name, eMail, contactNo, password);
	}

	public void choiceErrorMsg(String msg) {
		System.out.println(msg);
	}

	public void customerAddedMsg(Customer customer) {
		System.out.println(customer.getName() + " is added successfully\ncustomer id :" + customer.getCustomerId()
				+ "account no :" + customer.getAccountNumber());

	}

	public void customerNotFoundmsg(String msg) {
		System.err.println(msg);

	}
}
