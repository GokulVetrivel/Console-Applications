package com.gokul.coursemanagement.user;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;
import com.gokul.coursemanagement.util.GetInput;

public class UserView implements UserViewCallBack {
	
	private UserControllerViewCallBack userController;
	public UserView() {
		userController = new UserController(this);
	}
	public void create(User user) {
		userMenu(user);
	}
	
	 public void userMenu(User user) {
		boolean askAgain=true;
		do {
		System.out.println("------> User Page <------\n");
		System.out.println("1.view Profile\n2.view available courses\n3.Enroll Course\n4.my Courses\n9.back");
		String choice = GetInput.getChoice();
		int choice_v = userController.validateChoice(choice, user);
		
		switch(choice_v) {
		
		case 1:getProfile(user);
				break;
			
		case 2:getAvailableCourses();
				break;
				
		case 3:enrollCourse(user);
				break;
				
		case 4:getEnrolledCourses(user);
				break;
				
		case 9:askAgain=false;
				break;
				
		default: System.err.println("enter valid option..");	
		}
		}while(askAgain);
	}

	private void getProfile(User user) {
		System.out.println("User Name :"+user.getUserName()+"\nUser Email Id :"+user.getEmailId()+"\nPh.No :"+user.getPhoneNumber()
		+"\n");
		
	}

	private void getAvailableCourses() {
		List<Course> courses = userController.getAvailableCourses();
		for(Course course: courses) {
			System.out.println("Course Name :"+course.getCourseName()+"\tTrainer Name :"+course.getTrainerName()+"\tStart Date :"+course.getStartDate()
			+"\tEnd Start Date :"+course.getEndDate()+"\tcontents :"+course.getContents());
		}
	}

	private void enrollCourse(User user) {
		System.out.println("enter Course Name :");
		String courseName=GetInput.getName();
		userController.enrollCourse(user,courseName);
		
	}

	private void getEnrolledCourses(User user) {
		System.out.println(user.getCourseList());
		
	}

	public void choiceErrorMsg(String msg) {
		System.err.println(msg);
	}

	public void courseEnrolledMsg(String courseName) {
		System.out.println(courseName +" is enrolled...");
		
	}

	public void courseEnrollErrorMsg(String msg) {
		System.err.println(msg);
		
	}
		
	}
