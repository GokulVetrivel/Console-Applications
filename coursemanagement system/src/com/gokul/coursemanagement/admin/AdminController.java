package com.gokul.coursemanagement.admin;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;

public class AdminController implements AdminControllerViewCallBack, AdminControllerModelCallBack {
	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;
	private static int tId = 1;

	public AdminController(AdminView adminView) {
		this.adminView = adminView;
		adminModel = new AdminModel(this);
	}

	public int validateChoice(String choice) {
		int choice_v = 0;
		try {
			choice_v = Integer.parseInt(choice);
		} catch (Exception e) {
			System.err.println("choose valid option ...");
			adminView.adminMenu();
		}
		return choice_v;
	}

	public int calculateWeeks(String startDate, String endDate) {
		int months=0,days=0;
		LocalDate sDate = stringToDate(startDate);
		LocalDate eDate = stringToDate(endDate);
		if(sDate !=null && eDate !=null) {
		Period period = Period.between(sDate, eDate);
		months =period.getMonths();
		days = period.getDays();
		}
		return ((months * 30) + days) / 7;
	}

	private LocalDate stringToDate(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(date, format);
		} catch (Exception e) {
			adminView.invalidDateMsg("enter valid Date.. .enter again...");
		}
		return localDate;
	}

	public void addCourse(String courseName, String trainerId, String trainerName, String startDate, String endDate,
			String lastDate, int weeks, List<String> courseContent) {
		adminModel.addCourse(courseName, trainerId, trainerName, stringToDate(startDate), stringToDate(endDate),
				stringToDate(lastDate), weeks, courseContent);
	}

	public void addCourseSuccessfullMsg(Course course) {
		adminView.addCourseSuccessfullMsg(course);
	}

	public void addCourseFailurMsg(String msg) {
		adminView.addCourseFailurMsg(msg);

	}

	public void addTrainer(String trainerName, String emailId, String skillSets, String phoneNumber, String password) {
		if (!trainerName.matches("[A-Za-z]+"))
			adminView.nameErrorMsg("Please enter a valid UserName");
		else if (!emailId.matches("^[A-Za-z0-9]+@(.+)$"))
			adminView.emailIdErrorMsg("Please enter a valid EmailId");
		else if (!phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10)
			adminView.phoneNumberErrorMsg("Please enter a valid phone number");
		else {
			String[] temp = skillSets.split(",");
			List<String> skills = new ArrayList<>();
			for (int i = 0; i < temp.length; i++) {
				skills.add(temp[i]);
			}
			String trainerId = "TR000" + tId;
			tId++;
			adminModel.addTrainer(trainerId, trainerName, emailId, skills, phoneNumber, password);
		}
	}

	public void addTrainerSuccessMsg(Trainer trainer) {
		adminView.addTrainerSuccessMsg(trainer);

	}

}
