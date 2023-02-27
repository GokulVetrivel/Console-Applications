package com.gokul.coursemanagement.admin;

import java.util.ArrayList;
import java.util.List;

import com.gokul.coursemanagement.dto.Admin;
import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.util.GetInput;

public class AdminView implements AdminViewCallBack {
	private AdminControllerViewCallBack adminController;

	public AdminView() {
		adminController = new AdminController(this);
	}
	public void create() {
		adminMenu();
		
	}
	public void adminMenu() {
		
		boolean askAgain = true;
		do {
			System.out.println("------>Admin Menu Page<------\n");
			System.out.println("1.Add course \n2.Add Trainer \n9.Logout\n");
			System.out.print("Enter your choice:");
			String choice = GetInput.getChoice();
			int choice_v = adminController.validateChoice(choice);
			switch (choice_v) {

			case 1:
				addCourse();
				break;
			case 2:
				addTrainer();
				break;
			case 9:
				askAgain = false;
				break;
			default:
				System.err.println("Please enter a valid option..\n");
			}
		} while (askAgain);
	}

	private void addCourse() {
		System.out.println("-------> course adding page <-------\n");
		System.out.print("Enter Course Name:");
		String courseName = GetInput.getName();
		System.out.print("Enter Trainer Id:");
		String trainerId = GetInput.getId();
		System.out.print("Enter Trainer Name:");
		String trainerName = GetInput.getName();
		System.out.print("Enter Start Date of the Course (dd/mm/yyyy):");
		String startDate = GetInput.getDate();
		System.out.print("Enter End Date of the Course (dd/mm/yyyy):");
		String endDate = GetInput.getDate();
		System.out.print("Enter Last date to apply for Course (dd/mm/yyyy):");
		String lastDate = GetInput.getDate();
		int weeks = adminController.calculateWeeks(startDate, endDate);
		List<String> courseContent = new ArrayList<>();
		System.out.println("Enter weekly contents :");
		for (int i = 1; i <= weeks; i++) {
			System.out.printf("Week %d:", i);
			courseContent.add(GetInput.getContent());
		}
		adminController.addCourse(courseName,trainerId,trainerName,startDate,endDate,lastDate,weeks,courseContent);
	}

	private void addTrainer() {
		System.out.println("\n------>Add New Trainer Page<------\n");
		System.out.print("Enter Trainer Name:");
		String trainerName = GetInput.getName(); 
		System.out.print("Enter email Id:");
		String emailId = GetInput.getEmailId();
		System.out.print("Enter Trainer Password:");
		String password = GetInput.getPassword();
		System.out.print("Enter your Phone Number");
		String phoneNumber = GetInput.getPhoneNumber();
		System.out.print("Enter your skills(separated by comma(,)):");
		String skillSets = GetInput.getSkillSet();
		adminController.addTrainer(trainerName, emailId, skillSets, phoneNumber,password);

	}

	//****date invalid msg***/
	public void invalidDateMsg(String msg) {
		System.err.println(msg);
		//adminMenu();
	}

	public void addCourseSuccessfullMsg(Course course) {
		System.out.println(course.getCourseName()+" added successfully...");
	}

	public void addCourseFailurMsg(String msg) {
		System.out.println(msg);
		//adminMenu();
	}
	public void nameErrorMsg(String msg) {
		System.out.println(msg);
		//adminMenu();
		
	}
	public void emailIdErrorMsg(String msg) {
		System.out.println(msg);
		//adminMenu();
	}
	public void phoneNumberErrorMsg(String msg) {
		System.err.println(msg);
		//adminMenu();	
	}
	public void addTrainerSuccessMsg(Trainer trainer) {
		System.out.println(trainer.getTrainerName()+" is added to the tariners...\ntrainer id is :"+trainer.getTrainerId()+"\n");
	}
	
}
