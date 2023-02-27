package com.gokul.coursemanagement.dto;

import java.time.LocalDate;
import java.util.List;

public class Course {
	
	private String courseCode;
	private String courseName;
	private String trainerId;
	private String trainerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate lastDateToApply;
	private int duration;
	private List<String> contents;
	
	public Course(String courseName, String trainerId, String trainerName, LocalDate startDate,
			LocalDate endDate, LocalDate lastDateToApply, int duration, List<String> contents) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastDateToApply = lastDateToApply;
		this.duration = duration;
		this.contents = contents;
		
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getLastDateToApply() {
		return lastDateToApply;
	}
	public void setLastDateToApply(LocalDate lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	
	
}
