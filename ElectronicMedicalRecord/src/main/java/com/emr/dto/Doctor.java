package com.emr.dto;

public class Doctor {
	private int doctorId;
	private int clinicId;
	private String regdNo;
	private String doctorName;
	private String department;

	public Doctor(int doctorId, int clinicId, String doctorName, String regdNo, String department) {
		super();
		this.doctorId = doctorId;
		this.clinicId=clinicId;
		this.regdNo = regdNo;
		this.doctorName = doctorName;
		this.department = department;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getRegdNo() {
		return regdNo;
	}

	public void setRegdNo(String regdNo) {
		this.regdNo = regdNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
