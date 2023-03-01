package com.gokul.bankingapplication.login;

import com.gokul.bankingapplication.admin.AdminView;
import com.gokul.bankingapplication.customer.CustomerView;
import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.util.GetInput;

public class LoginView implements LoginViewCallBack {
	private LoginControllerViewCallBack loginController;

	public LoginView() {
		this.loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.mainMenu();
	}

	private void mainMenu() {
		boolean askAgain = true;
		do {
			System.out.println("1.login as admin\n2.login as customer\n9.exit");
			System.out.println("your choice :");
			String choice = GetInput.getString();
			int choice_v = loginController.validateChoice(choice);
			switch (choice_v) {

			case 1:
				adminLogin();
				break;

			case 2:
				customerLogin();
				break;

			case 9:
				askAgain = false;
				break;

			default:
				System.err.println("choose available option...");

			}
		} while (askAgain);

	}

	// ***choice validation***//
	public void choiceErrorMsg(String msg) {
		System.out.println(msg);
		mainMenu();
	}

	private void customerLogin() {
		System.out.println("----->customer login page<-----\n");
		System.out.print("customer Id :");
		String customerId = GetInput.getString();
		int customerId_v = 0;
		try {
			customerId_v = Integer.parseInt(customerId);
		} catch (Exception e) {
			System.out.println("enter valid customer id...");
			mainMenu();
		}
		System.out.print("password :");
		String password = GetInput.getString();

		loginController.isCustomer(customerId_v, password);
	}

	// ****admin login***//
	private void adminLogin() {
		System.out.println("----->admin login page<-----\n");
		System.out.print("admin Id :");
		String adminId = GetInput.getString();
		System.out.print("password :");
		String password = GetInput.getString();

		loginController.isAdmin(adminId, password);
	}

	public void adminLoginSuccess(Admin admin) {
		System.out.println("welcome, " + admin.getAdminName());
		AdminView adminView = new AdminView();
		adminView.create();
	}

	public void adminLoginFailureMsg(String msg) {
		System.err.println(msg);
		mainMenu();
	}

	public void customerLoginSuccess(Customer customer) {
		System.out.println("welcome, " + customer.getName());
		CustomerView customerView = new CustomerView();
		customerView.create(customer);
	}

	public void customerLoginFailureMsg(String msg) {
		System.err.println(msg);
		mainMenu();
	}
}
