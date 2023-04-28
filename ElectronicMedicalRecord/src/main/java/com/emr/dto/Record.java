package com.emr.dto;

import java.sql.Date;

public class Record {
	private int clinicId;
	private String clinicName;
	private Date visitedOn;
	private String visitedFor;
	private String clinicalNotes;
	private String doctorName;
	private String regdNo;
	private int visitId;
	
	
	public Record(int clinicId, String clinicName, Date visitedOn, String visitedFor, String clinicalNotes,
			String doctorName, String regdNo, int visitId) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.visitedOn = visitedOn;
		this.visitedFor = visitedFor;
		this.clinicalNotes = clinicalNotes;
		this.doctorName = doctorName;
		this.regdNo = regdNo;
		this.visitId = visitId;
	}
	public int getClinicId() {
		return clinicId;
	}
	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public Date getVisitedOn() {
		return visitedOn;
	}
	public void setVisitedOn(Date visitedOn) {
		this.visitedOn = visitedOn;
	}
	public String getVisitedFor() {
		return visitedFor;
	}
	public void setVisitedFor(String visitedFor) {
		this.visitedFor = visitedFor;
	}
	public String getClinicalNotes() {
		return clinicalNotes;
	}
	public void setClinicalNotes(String clinicalNotes) {
		this.clinicalNotes = clinicalNotes;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getRegdNo() {
		return regdNo;
	}
	public void setRegdNo(String regdNo) {
		this.regdNo = regdNo;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	
}
