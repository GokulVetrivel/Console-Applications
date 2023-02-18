package com.gokul.flightticketbooking.login;

import com.gokul.flightticketbooking.dto.Admin;

public interface LoginControllerModelCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailiure(String string);

}
