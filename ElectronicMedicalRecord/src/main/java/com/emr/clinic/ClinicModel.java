package com.emr.clinic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import com.emr.dto.Doctor;
import com.emr.dto.Medicine;
import com.emr.dto.Patient;
import com.emr.dto.Visit;
import com.emr.dto.Record;
import com.emr.repository.Repository;

public class ClinicModel {
	public ClinicModel() {}
	
//	public static void main(String[] args) {
//		int visitId=addVisit(2,10,Date.valueOf("2023-02-22"),"diaryea","food possion","12345");
//	System.out.println(visitId);
//	}
	
	public List<Visit> getVisits(int eMRNo) {
		return Repository.getInstance().getVisits(eMRNo);
		
	}
	public boolean addDoctor(int clinicId, String name, String regdNo, String Department) {
		return Repository.getInstance().addDoctor(clinicId, name, regdNo, Department);
	}
	
	public List<Doctor> getDoctors(int clinicId){
		return Repository.getInstance().getDoctors(clinicId);
	}
	
	public int addPatient(String name, String gender, Date dob, String fatherName, String motherName) {
		return Repository.getInstance().addPatient(name, gender, dob, fatherName, motherName);	
	}
	
	public Patient getPatient(int eMRNo) {
		return Repository.getInstance().getPatient(eMRNo);	
	}
	
	public int addVisit(int clinicId, int eMRNo, String visitedFor, String clinicalNotes, String doctorRegdNo) {
		return Repository.getInstance().addVisit(clinicId, eMRNo,  visitedFor, clinicalNotes, doctorRegdNo);	
	}

	public void addMedication(int visitId, String medicineName, String bfaf, int morning, int noon, int night,
			int days) {
		// TODO Auto-generated method stub
		Repository.getInstance().addMedication(visitId,medicineName, bfaf, morning, noon, night, days);
	}
	public List<Record> getRecords(int eMRNo){
		List<Record> records=Repository.getInstance().getRecords(eMRNo);
		return records;
	}
	
	public List<Medicine> getMedicines(int visitId){
		List<Medicine> medicines = Repository.getInstance().getMedicines(visitId);
		return medicines;
	}
}
