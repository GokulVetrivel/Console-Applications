package com.gokul.coursemanagement.admin;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;

public interface AdminControllerModelCallBack {

	void addCourseSuccessfullMsg(Course course);

	void addCourseFailurMsg(String string);

	void addTrainerSuccessMsg(Trainer trainer);

}
