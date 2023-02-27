package com.gokul.coursemanagement.login;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.User;

public interface LoginViewCallBack {

	void mainMenu();

	void notValidEmailMsg(String string);

	void passwordMismatchMsg(String string);

	void adminLoginSuccessMsg(Admin admin);

	void adminLoginFailureMsg(String msg);

	void trainerLoginSuccessMsg(Trainer trainer);

	void trainerLoginFailureMsg(String msg);

	void userAddedSuccessMsg(String msg);

	void existingUserNameMsg(String msg);

	void userLoginSucccesMsg(User user);

	void userLoginFailureMsg(String msg);

}
