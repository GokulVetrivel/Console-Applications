package com.gokul.coursemanagement.user;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;

public class UserController implements UserControllerViewCallBack, UserControllerModelCallBack {
	
	private UserViewCallBack userView;
	private UserModelCallBack userModel;

	public UserController(UserView userView) {
		this.userView = userView;
		this.userModel = new UserModel(this);
	}

	public int validateChoice(String choice, User user) {
		int choice_v=0;
		try {
			choice_v=Integer.parseInt(choice);
		}
		catch(Exception e) {
			userView.choiceErrorMsg("chhose valid option");
			userView.userMenu(user);
		}
		return choice_v;
	}

	public List<Course> getAvailableCourses() {
		return userModel.getAvailableCourses();
	}

	public void enrollCourse(User user, String courseName) {
		userModel.enrollCourse(user,courseName);
		
	}

	public void courseEnrolledMsg(String courseName) {
		userView.courseEnrolledMsg(courseName);
		
	}

	public void courseEnrollErrorMsg(String msg) {
		userView.courseEnrollErrorMsg(msg);
	}
}
