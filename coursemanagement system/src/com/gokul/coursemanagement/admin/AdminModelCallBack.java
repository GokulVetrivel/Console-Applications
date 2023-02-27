package com.gokul.coursemanagement.admin;

import java.time.LocalDate;
import java.util.List;

import com.gokul.coursemanagement.dto.Trainer;

public interface AdminModelCallBack {

	void addCourse(String courseName, String trainerId, String trainerName, LocalDate stringToDate,
			LocalDate stringToDate2, LocalDate stringToDate3, int weeks, List<String> courseContent);

	Trainer addTrainer(String trainerId, String trainerName, String emailId, List<String> skills, String phoneNumber,
			String password);

}
