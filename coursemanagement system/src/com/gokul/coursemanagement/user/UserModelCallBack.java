package com.gokul.coursemanagement.user;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;

public interface UserModelCallBack {

	List<Course> getAvailableCourses();

	void enrollCourse(User user, String courseName);

}
