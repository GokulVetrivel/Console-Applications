package com.emr.dto;

import java.util.Date;

public class Visit {
	private int clinicId;
	private String clinicName;
	private int eMRNo;
	private Date visitedOn;
	private String visitedFor;
	private String medication;
	private String clinicalNotes;
	private String doctorName;
	private String doctorRegdNo;
	public Visit(int clinicId, String clinicName, int eMRNo, Date visitedOn, String visitedFor, String medication, String clinicalNotes,
			String doctorName, String doctorRegdNo) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.eMRNo = eMRNo;
		this.visitedOn = visitedOn;
		this.visitedFor = visitedFor;
		this.medication = medication;
		this.clinicalNotes = clinicalNotes;
		this.doctorName = doctorName;
		this.doctorRegdNo=doctorRegdNo;
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
	public int geteMRNo() {
		return eMRNo;
	}
	public void seteMRNo(int eMRNo) {
		this.eMRNo = eMRNo;
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
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
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
	public String getDoctorRegdNo() {
		return doctorRegdNo;
	}
	public void setDoctorRegtNo(String doctorRegdNo) {
		this.doctorRegdNo = doctorRegdNo;
	}
}
