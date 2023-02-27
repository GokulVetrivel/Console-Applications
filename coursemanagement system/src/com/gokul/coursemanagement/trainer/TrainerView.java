package com.gokul.coursemanagement.trainer;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.util.GetInput;

public class TrainerView implements TrainerViewCallBack {
	private TrainerControllerViewCallBack trainerController;
	
	public TrainerView() {
		trainerController = new TrainerController(this);
	}
	
	public void create(Trainer trainer) {
		trainerMenu(trainer);
	}
	
	 public void trainerMenu(Trainer trainer) {
		boolean askAgain = true;
		do {
		System.out.println("1.view profile\n2.add Skills\n3.view Scheduled courses\n9.back");
		String choice=GetInput.getChoice();
		int choice_v=trainerController.validatchoice(choice, trainer);
		switch(choice_v) {
		
		case 1:getTrainerProfile(trainer);
				break;
				
		case 2:addSkills(trainer);
				break;
				
		case 3:getScheduledCourses(trainer);
				break;
			
		case 9:askAgain=false;
				break;
				
		default :System.err.println("enter valid choice...");
		}
		}while(askAgain);
		
	}

	private void getScheduledCourses(Trainer trainer) {
		List<Course> ScheduledCourses = trainerController.getScheduledCourses(trainer);
		System.out.println("Scheduled courses :");
		for(Course ScheduledCourse : ScheduledCourses)
			System.out.println("Course name :"+ScheduledCourse.getCourseName()+"\t Course Start Date :"+ScheduledCourse.getStartDate()
			+"\tCourse end Date :"+ScheduledCourse.getEndDate()+"\tcontents :"+ScheduledCourse.getContents());
		
	}

	private void addSkills(Trainer trainer) {
		System.out.print("enter skill :");
		String skill=GetInput.getSkillSet();
		trainer.getSkillSet().add(skill);
		System.out.println(skill +"is added to skills list...");
	}

	private void getTrainerProfile(Trainer trainer) {
		System.out.println("Trainer Name :"+trainer.getTrainerName()+"\nTrainer Id :"+trainer.getTrainerId()+
				"\nTrainer ph.No :"+trainer.getPhoneNumber()+"\nE mail :"+trainer.getEmailId()+"\nSkills :");
		for(String skill:trainer.getSkillSet())
			System.out.println(skill);

	}

	public void choiceErrorMsg(String msg) {
		System.out.println(msg);
		
	}

	
}
