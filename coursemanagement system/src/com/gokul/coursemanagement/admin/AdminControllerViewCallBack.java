package com.gokul.coursemanagement.admin;

import java.util.List;

public interface AdminControllerViewCallBack {

	int validateChoice(String choice);

	int calculateWeeks(String startDate, String endDate);

	void addCourse(String courseName, String trainerId, String trainerName, String startDate, String endDate,
			String lastDate, int weeks, List<String> courseContent);

	void addTrainer(String trainerName, String emailId, String skillSets, String phoneNumber, String password);

}
