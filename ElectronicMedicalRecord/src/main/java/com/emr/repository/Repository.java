package com.emr.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.emr.dto.Clinic;
import com.emr.dto.Doctor;
import com.emr.dto.Medicine;
import com.emr.dto.Patient;
import com.emr.dto.Visit;
import com.emr.dto.Record;

public class Repository {
	private static Repository repositoryInstance;
	private Connection con;
	private Statement stmt;

	private Repository() {
	}

	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMR", "root", "Gokul@1998");
			stmt = con.createStatement();
		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public static Repository getInstance() {
		if (repositoryInstance == null) {
			repositoryInstance = new Repository();
			repositoryInstance.getConnection();
		}

		return repositoryInstance;
	}

	public Clinic isClinic(String clinicName, String password) {
		String query = "select * from clinicCredentials where clinicName=? and password=?;";
		Clinic clinic=null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, clinicName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
			int clinicId= resultSet.getInt(1);
			String clinicAddress= resultSet.getString(3);
			String clinicPhoneNo=  resultSet.getString(4);
			String clinicEmail= resultSet.getString(5);
			clinic=new Clinic(clinicId,clinicName,clinicAddress,clinicPhoneNo,clinicEmail);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clinic;
	}
	
	/**
	 * 	
	 * @param eMRNo
	 * @return list of visit objects for the emr no
	 */
	public List<Visit> getVisits(int eMRNo) {//query change needed visit.visitid=medications.visitId
		String query = "select clinicCredentials.clinicId,clinicName,visitedOn,visitedFor,medication,clinicalNotes,doctorName,regdNo\r\n"
				+ "	from visits inner join clinicCredentials on clinicCredentials.clinicId=visits.clinicId \r\n"
				+ "		inner join Doctors on visits.doctorId=Doctors.doctorId "
				+ "inner join medications on visits.medicationId = medications.medicationId where emrNo= " + eMRNo + ";";

//		System.out.println(query);
		List<Visit> visits = new ArrayList();
		try {
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				int clinicId = resultSet.getInt(1);
				String clinicName = resultSet.getString(2);
				Date visitedOn = resultSet.getDate(3);
				String visitedFor = resultSet.getString(4);
				String medication = resultSet.getString(5);
				String clinicalNotes = resultSet.getString(6);
				String doctorName = resultSet.getString(7);
				String doctorRegdNo = resultSet.getString(8);
				visits.add(new Visit(clinicId, clinicName, eMRNo, visitedOn, visitedFor, medication, clinicalNotes,
						doctorName, doctorRegdNo));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visits;

	}

	public boolean addClinic(String clinicName, String clinicAddress, String clinicPhoneNo, String eMailId, String password) {
		String query= "insert into clinicCredentials (clinicName,clinicAddress,clinicPhoneNO,clinicEMail,password) values (?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1,clinicName);
			preparedStatement.setString(2,clinicAddress);
			preparedStatement.setString(3,clinicPhoneNo);
			preparedStatement.setString(4,eMailId);
			preparedStatement.setString(5,password);
			int rows=preparedStatement.executeUpdate();
			return rows!=0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * 
	 */
	public boolean addDoctor(int clinicId, String regdNo, String name, String department) {
		String query="insert into doctors (clinicId,doctorName,regdNo,department) values(?,?,?,?);";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1,clinicId);
			preparedStatement.setString(2,regdNo);
			preparedStatement.setString(3,name);
			preparedStatement.setString(4,department);
			int rows=preparedStatement.executeUpdate();
			return rows!=0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param clinicId
	 * @return list of doctor objects in the clinic
	 */
	public List<Doctor> getDoctors(int clinicId) {
		String query="select * from doctors where clinicId="+clinicId+";";
		List<Doctor> doctors=new ArrayList<Doctor>();
		try {
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
			int doctorId = resultSet.getInt(2);
			String doctorName = resultSet.getString(3);
			String regdNo = resultSet.getString(4);
			String department = resultSet.getString(5);
			doctors.add(new Doctor(clinicId, doctorId, doctorName, regdNo, department));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctors;
	}
	/**
	 * 
	 * @param name
	 * @param age
	 * @param gender
	 * @param dob
	 * @param fatherName
	 * @param motherName
	 * @return the emr no of the patient
	 */
	public int addPatient(String name, String gender, Date dob, String fatherName, String motherName) {
		String query="insert into patients (name,gender,dob,fatherName,motherName) values (?,?,?,?,?);";
		
		int eMRNo=0;
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,gender);
			preparedStatement.setDate(3,new java.sql.Date(dob.getTime()));
			preparedStatement.setString(4,fatherName);
			preparedStatement.setString(5,motherName);
			int rows=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * to get the emr no of the newly registered patient
		 */
		String eMRNoQuery="select max(eMRNo) from patients";
		try {
			ResultSet resultSet=stmt.executeQuery(eMRNoQuery);
			resultSet.next();
			eMRNo=resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eMRNo;
	}

	public Patient getPatient(int eMRNo) {
		String query="SELECT *, DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), dob)), '%Y') + 0 AS age FROM patients where eMRNo="+eMRNo+";";
		Patient patient=null;
		try {
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			String name = resultSet.getString(2);
			String gender = resultSet.getString(3);
			Date dob = resultSet.getDate(4);
			String fatherName = resultSet.getString(5);
			String motherName = resultSet.getString(6);
			byte age = resultSet.getByte(7);
			
			patient = new Patient(eMRNo,name,age,gender,dob,fatherName,motherName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient;
	}

	public int addVisit(int clinicId, int eMRNo, String visitedFor,
		 String clinicalNotes, String doctorRegdNo) {
		// TODO Auto-generated method stub
		String query ="insert into visits(clinicId,eMRNo,visitedFor,clinicalNotes,regdNo) values (?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1, clinicId);
			preparedStatement.setInt(2, eMRNo);
			preparedStatement.setString(3, visitedFor);
			preparedStatement.setString(4, clinicalNotes);
			preparedStatement.setString(5, doctorRegdNo);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int visitId=0;
		String visitIdQuery="select max(visitId) from visits";
		try {
			ResultSet resultSet=stmt.executeQuery(visitIdQuery);
			resultSet.next();
			visitId=resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return visitId;
	}

	public void addMedication(int visitId, String medicineName, String bfaf, int morning, int noon, int night,
			int days) {
		// TODO Auto-generated method stub
		String query = "insert into medications(visitId,medication,bfaf,morning,noon,night,days) values (?,?,?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1, visitId);
			preparedStatement.setString(2, medicineName);
			preparedStatement.setString(3, bfaf);
			preparedStatement.setInt(4, morning);
			preparedStatement.setInt(5, noon);
			preparedStatement.setInt(6, night);
			preparedStatement.setInt(7, days);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Record> getRecords(int eMRNo) {
		// TODO Auto-generated method stub
		List<Record> records = new ArrayList();
		String query ="select clinicCredentials.clinicId,clinicName,visitedOn,visitedFor,"
				+ "clinicalNotes,doctorName,Doctors.regdNo,visits.visitId "
				+ "from visits inner join clinicCredentials on clinicCredentials.clinicId="
				+ "visits.clinicId inner join Doctors on visits.regdNo=Doctors.regdNo "
				+ " where emrNo="+eMRNo+";";
		try {
			ResultSet resultSet=stmt.executeQuery(query);
			while(resultSet.next()) {
				int clinicId = resultSet.getInt(1);
				String clinicName = resultSet.getString(2);
				Date visitedOn = resultSet.getDate(3);
				String visitedFor = resultSet.getString(4);
				String clinicalNotes = resultSet.getString(5);
				String doctorName = resultSet.getString(6);
				String regdNo = resultSet.getString(7);
				int visitId = resultSet.getInt(8);
				records.add(new Record(clinicId,clinicName,visitedOn,visitedFor,clinicalNotes,doctorName,regdNo,visitId));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}

	public List<Medicine> getMedicines(int visitId) {
		// TODO Auto-generated method stub
		List<Medicine> medicines = new ArrayList();
		String query = "select * from medications where visitId="+visitId+";";
		try {
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				String medicine = resultSet.getString(3);
				String bfaf = resultSet.getString(4);
				int morning = resultSet.getInt(5);
				int noon = resultSet.getInt(6);
				int night = resultSet.getInt(7);
				int days = resultSet.getInt(8);
				medicines.add(new Medicine(visitId, medicine, bfaf, morning, noon, night, days));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicines;
	}
	
}
