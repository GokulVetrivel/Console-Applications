package com.gokul.bankingapplication.repository;

import java.util.ArrayList;
import java.util.List;

import com.gokul.bankingapplication.dto.Admin;
import com.gokul.bankingapplication.dto.AdminCredentials;
import com.gokul.bankingapplication.dto.Customer;
import com.gokul.bankingapplication.dto.CustomerCredentials;

public class BankingRepository {
	private static BankingRepository bankingDbInstance;
	
	private List<AdminCredentials> adminCredentials = new ArrayList<AdminCredentials>();
	private List<CustomerCredentials> customerCredentials = new ArrayList<CustomerCredentials>();
	
	private static int customerId = 10001,accountNo=1000001;
	
	private BankingRepository() {}
	
	public static BankingRepository getInstance() {
		if(bankingDbInstance == null) {
			bankingDbInstance=new BankingRepository();
			bankingDbInstance.addAdmin();
		}
		return bankingDbInstance;
	}

	private void addAdmin() {
		adminCredentials.add(new AdminCredentials("0001","gokul","ZSGS"));
		
	}

	public Admin isAdmin(String adminId, String password) {
		for(AdminCredentials adminCredential : adminCredentials) {
			if(adminCredential.getAdminId().equals(adminId) && adminCredential.getPassword().equals(password))
				return adminCredential;
		}
		return null;
	}

	public Customer isCustomer(int customerId, String password) {
		for(CustomerCredentials customerCredential : customerCredentials) {
			if(customerCredential.getCustomerId() == customerId && customerCredential.getPassword().equals(password))
				return customerCredential;
		}
		return null;
	}

	public Customer addCustomer(String name, String eMail, String contactNo, String password) {
		CustomerCredentials currCustomerCredentials = new CustomerCredentials(accountNo++, name, customerId++, eMail, contactNo, password);
		System.out.println( customerCredentials.add(currCustomerCredentials));
		
		return currCustomerCredentials;
	}

	public Customer getCustomer(int customerId) {
		for(CustomerCredentials customerCredential: customerCredentials) {
			if(customerCredential.getCustomerId()==customerId)
				return customerCredential;
		}
		return null;
	}

	public void deposit(int amount_v, Customer customer) {
		double sum=customer.getBalance()+amount_v;
		customer.setBalance(sum);	
	}

	public void withdraw(int amount_v, Customer customer) {
		customer.setBalance((double)(customer.getBalance()-amount_v));
	}

	public Customer transfer(int amount_v, Customer customer, int payeeAccountNo_v) {
		for(CustomerCredentials customerCredential: customerCredentials) {
			if(customerCredential.getAccountNumber()==payeeAccountNo_v) {
				customerCredential.setBalance(customerCredential.getBalance()+amount_v);
				return customerCredential;
			}
		}
		return null;
	}
}
