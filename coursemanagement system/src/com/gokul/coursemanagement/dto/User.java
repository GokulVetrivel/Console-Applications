package com.gokul.coursemanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String userName;
	private String emailId;
	private String phoneNumber;
	private List<String> courseList = new ArrayList<>();
	
	public User(String userName, String emailId, String phoneNumber) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getCourseList() {
		return courseList;
	}
	
	public void addCourse(String courseId) {
		courseList.add(courseId);
	}
}
