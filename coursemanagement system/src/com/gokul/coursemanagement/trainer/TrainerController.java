package com.gokul.coursemanagement.trainer;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;

public class TrainerController implements TrainerControllerViewCallBack, TrainerControllerModelCallBack {
	private TrainerViewCallBack trainerView;
	private TrainerModelCallBack trainerModel;
	public TrainerController(TrainerView trainerView) {
		this.trainerView=trainerView;
		trainerModel=new TrainerModel(this);
	}
	public int validatchoice(String choice, Trainer trainer) {
		int choice_v=0;
		try {
			choice_v=Integer.parseInt(choice);
		}catch(Exception e) {
			trainerView.choiceErrorMsg("choose valid option...");
			trainerView.trainerMenu(trainer);
		}
		return choice_v;
	}
	public List<Course> getScheduledCourses(Trainer trainer) {
		return trainerModel.getScheduledCourses(trainer);
		
	}

}
