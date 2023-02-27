package com.gokul.coursemanagement.dto;

import java.util.List;

public class TrainerCredentials extends Trainer {
	
	private String password;
	
	public TrainerCredentials(String trainerId, String trainerName, String emailId, List<String> skillSet,
			String phoneNumber, String password) {
		super(trainerId, trainerName, emailId, skillSet, phoneNumber);
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
