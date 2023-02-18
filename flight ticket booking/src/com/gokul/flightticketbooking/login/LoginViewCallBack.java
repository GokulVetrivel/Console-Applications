package com.gokul.flightticketbooking.login;

import com.gokul.flightticketbooking.dto.Admin;

public interface LoginViewCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailed(String errMessage);

}
