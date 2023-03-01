package com.gokul.bankingapplication.customer;

public interface CustomerControllerModelCallBack {

	void noSufficientBalanceMsg(String string);

	void payeeAccountNotExitMsg(String string);

}
