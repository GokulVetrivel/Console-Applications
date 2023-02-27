package com.gokul.coursemanagement.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.AdminCredentials;
import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.User;
import com.gokul.coursemanagement.dto.UserCredentials;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.dto.TrainerCredentials;

public class CourseManagementRepository {
	
	private static CourseManagementRepository coursedbInstance;
	
	private List<AdminCredentials> adminCredentials=new ArrayList();
	private List<TrainerCredentials>  trainerCredentials=new ArrayList();
	private List<UserCredentials> usersCredentials = new ArrayList();
	private List<Course> courses = new ArrayList();
	private CourseManagementRepository() {
		
	}
	
	public static CourseManagementRepository getInstance() {
		if(coursedbInstance==null) {
			coursedbInstance=new CourseManagementRepository();
			coursedbInstance.addAdmin();
		}
		return coursedbInstance;
	}
	/******initial setup *****/
	private void addAdmin() {
		adminCredentials.add(new AdminCredentials("gokul1998","gokul","ZSGS"));
	}

	public Admin isValidAdmin(String adminId, String password) {
		for(AdminCredentials adminCredential : adminCredentials) {
			if(adminCredential.getAdminId().equals(adminId) && adminCredential.getPassword().equals(password))
				return adminCredential;
		}
		return null;
	}

	public Trainer isValidTrainer(String trainerId, String password) {
		
		for(TrainerCredentials trainerCredential : trainerCredentials) {
			if(trainerCredential.getTrainerId().equals(trainerId) && trainerCredential.getPassword().equals(password))
				return trainerCredential;
		}
		return null;
	}

	public User addUser(String userName, String emailId, String password, String phoneNumber) {
		for(UserCredentials userCredential:usersCredentials) {
			if(userCredential.getUserName().equals(userName)) {
				return null;
			}
		}
		UserCredentials currUserCredential=new UserCredentials(userName, emailId, phoneNumber, password);
		usersCredentials.add(currUserCredential);
		return currUserCredential;
		
	}

	public User isValidUser(String userName, String password) {
		for(UserCredentials userCredential:usersCredentials) {
			if(userCredential.getUserName().equals(userName) && userCredential.getPassword().equals(password)) {
				return userCredential;
			}
		}
		return null;
	}

	public Course addCourse(String courseName, String trainerId, String trainerName, LocalDate startDate, LocalDate endDate,
			LocalDate lastDate, int weeks, List<String> courseContent) {
		Course currCourse =null;
		for(Trainer trainer: trainerCredentials) {
			if(trainer.getTrainerId().equals(trainerId))
				currCourse = new Course(courseName,trainerId,trainerName,startDate,endDate,lastDate,weeks,courseContent);
				courses.add(currCourse);
				return currCourse;
		}
		return null;
	}

	public Trainer addTrainer(String trainerId, String trainerName, String emailId, List<String> skills,
			String phoneNumber, String password) {
		TrainerCredentials currTrainerCredentials = new TrainerCredentials(trainerId,trainerName,emailId,skills,phoneNumber,password);
		trainerCredentials.add(currTrainerCredentials);
		return currTrainerCredentials;
	}

	public List<Course> getScheduledCourses(Trainer trainer) {
		List<Course> ScheduledCourses = new ArrayList();
		for(Course course : courses) {
			if(course.getTrainerId().equals(trainer.getTrainerId()))
				ScheduledCourses.add(course);
		}
		return ScheduledCourses;
	}

	public List<Course> getAvailableCourses() {
		return courses;
	}

	public boolean enrollCourse(User user, String courseName) {
		for(Course course:courses) {
			if(course.getCourseName().equals(courseName)) {
				user.getCourseList().add(courseName);
				return true;
			}
		}
		return false;
	}
}
