package com.gokul.coursemanagement.admin;

import java.time.LocalDate;
import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.repository.CourseManagementRepository;

public class AdminModel implements AdminModelCallBack {
	private AdminControllerModelCallBack adminController;

	public AdminModel(AdminController adminController) {
		this.adminController = adminController;
	}

	public void addCourse(String courseName, String trainerId, String trainerName, LocalDate startDate,
			LocalDate endDate, LocalDate lastDate, int weeks, List<String> courseContent) {
		Course course = CourseManagementRepository.getInstance().addCourse(courseName, trainerId, trainerName,
				startDate, endDate, lastDate, weeks, courseContent);
		if (course != null) {
			adminController.addCourseSuccessfullMsg(course);
		} else
			adminController.addCourseFailurMsg("Trainer Id is not exiting...");
	}

	public Trainer addTrainer(String trainerId, String trainerName, String emailId, List<String> skills,
			String phoneNumber, String password) {

		Trainer trainer = CourseManagementRepository.getInstance().addTrainer(trainerId, trainerName, emailId, skills,
				phoneNumber, password);
		adminController.addTrainerSuccessMsg(trainer);
		return trainer;
	}

}
