package com.gokul.coursemanagement.trainer;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;
import com.gokul.coursemanagement.repository.CourseManagementRepository;

public class TrainerModel implements TrainerModelCallBack {
	private TrainerControllerModelCallBack trainerController;
	public TrainerModel(TrainerController trainerController) {
		this.trainerController = trainerController;
	}
	public List<Course> getScheduledCourses(Trainer trainer) {
		List<Course> ScheduledCourses=CourseManagementRepository.getInstance().getScheduledCourses(trainer);
		return ScheduledCourses;
	}

}
