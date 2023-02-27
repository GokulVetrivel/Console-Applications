package com.gokul.coursemanagement.user;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;
import com.gokul.coursemanagement.repository.CourseManagementRepository;

public class UserModel implements UserModelCallBack {
private UserControllerModelCallBack userController;
	
	public UserModel(UserController userController) {
		this.userController = userController;
	}
	
	public List<Course> getAvailableCourses(){
		List<Course> availableCourses = CourseManagementRepository.getInstance().getAvailableCourses();
		return availableCourses;
	}

	public void enrollCourse(User user, String courseName) {
		if(CourseManagementRepository.getInstance().enrollCourse(user,courseName))
			userController.courseEnrolledMsg(courseName);
		else
			userController.courseEnrollErrorMsg("course is not Available...");
		
	}
}
