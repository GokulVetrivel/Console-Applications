package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;

public interface AdminViewCallBack {

	void choiceErrorMsg(String string);

	void customerAddedMsg(Customer customer);

	void customerNotFoundmsg(String msg);

}
