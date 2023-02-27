package com.gokul.coursemanagement.login;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.User;

public interface LoginControllerModelCallBack {

	void adminLoginSuccessMsg(Admin admin);

	void adminLoginFailureMsg(String string);

	void trainerLoginSuccessMsg(Trainer trainer);

	void trainerLoginFailureMsg(String string);

	void userAddedSuccessMsg(String string);

	void existingUserNameMsg(String string);

	void userLoginSucccesMsg(User user);

	void userLoginFailueMsg(String string);

}
