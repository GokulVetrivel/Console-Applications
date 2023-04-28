package com.emr.dto;

public class Doctorcredentials extends Doctor {
	private String password;

	public Doctorcredentials(int doctorId, int clinicId, String regtNo, String doctorName, String department, String password) {
		super(doctorId, clinicId, regtNo, doctorName, department);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
