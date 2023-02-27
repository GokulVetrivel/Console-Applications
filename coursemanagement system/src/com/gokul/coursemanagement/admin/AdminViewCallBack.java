package com.gokul.coursemanagement.admin;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;

public interface AdminViewCallBack {

	void adminMenu();

	void invalidDateMsg(String string);

	void addCourseSuccessfullMsg(Course course);

	void addCourseFailurMsg(String msg);

	void nameErrorMsg(String string);

	void emailIdErrorMsg(String string);

	void phoneNumberErrorMsg(String string);

	void addTrainerSuccessMsg(Trainer trainer);

}
