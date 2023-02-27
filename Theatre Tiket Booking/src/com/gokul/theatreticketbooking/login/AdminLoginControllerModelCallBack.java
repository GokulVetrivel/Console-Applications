package com.gokul.theatreticketbooking.login;

import com.gokul.theatreticketbooking.dto.Admin;

public interface AdminLoginControllerModelCallBack {

	void successLoginMsg(Admin user);

	void failedLoginMsg();

}
