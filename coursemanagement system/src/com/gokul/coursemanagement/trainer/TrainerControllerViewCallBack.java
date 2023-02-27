package com.gokul.coursemanagement.trainer;

import java.util.List;

import com.gokul.coursemanagement.dto.Course;
import com.gokul.coursemanagement.dto.Trainer;

public interface TrainerControllerViewCallBack {

	int validatchoice(String choice, Trainer trainer);

	List<Course> getScheduledCourses(Trainer trainer);

}
