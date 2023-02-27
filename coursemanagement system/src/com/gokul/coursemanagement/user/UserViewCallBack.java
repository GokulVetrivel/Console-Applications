package com.gokul.coursemanagement.user;

import com.gokul.coursemanagement.dto.User;

public interface UserViewCallBack {

	void choiceErrorMsg(String string);

	void userMenu(User user);

	void courseEnrolledMsg(String courseName);

	void courseEnrollErrorMsg(String msg);

}
