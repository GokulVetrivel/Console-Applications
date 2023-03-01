package com.gokul.bankingapplication.admin;

import com.gokul.bankingapplication.dto.Customer;

public interface AdminControllerModelCallBack {

	void customerAddedMsg(Customer customer);

	void customerNotFoundmsg(String string);

}
