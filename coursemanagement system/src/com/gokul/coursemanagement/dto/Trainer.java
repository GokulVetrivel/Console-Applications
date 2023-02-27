package com.gokul.coursemanagement.dto;

import java.util.List;

public class Trainer {
	private String trainerId;
	private String trainerName;
	private String emailId;
	private List<String> skillSet;
	private String phoneNumber;
	
	public Trainer(String trainerId, String trainerName, String emailId, List<String> skillSet, String phoneNumber) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.emailId = emailId;
		this.skillSet = skillSet;
		this.phoneNumber = phoneNumber;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<String> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void addSkillSet(String skill) {
		skillSet.add(skill);
	}
}
