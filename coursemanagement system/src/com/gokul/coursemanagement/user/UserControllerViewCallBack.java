package com.gokul.coursemanagement.user;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;

public interface UserControllerViewCallBack {

	int validateChoice(String choice, User user);

	List<Course> getAvailableCourses();

	void enrollCourse(User user, String courseName);

}
