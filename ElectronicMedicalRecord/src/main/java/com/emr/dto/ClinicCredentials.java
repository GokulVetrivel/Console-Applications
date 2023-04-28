package com.emr.dto;

public class ClinicCredentials extends Clinic{
	private String password;
	public ClinicCredentials(int clinicId, String clinicName, String clinicAddress, String clinicPhoneNo,
			String eMailId, String password) {
		super(clinicId, clinicName, clinicAddress, clinicPhoneNo, eMailId);
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
