package com.gokul.bankingapplication.customer;

public interface CustomerViewCalBack {

	void noSufficientBalanceMsg(String msg);

	void payeeAccountNotExitMsg(String msg);

}
