package com.emr.dto;

import java.sql.Date;

public class Patient {
		private int eMRNo;
		private String name;
		private byte age;
		private String gender;
		private Date dOB;
		private String fatherName;
		private String motherName;
		public Patient(int eMRNo, String name, byte age, String gender, Date dOB, String fatherName,
				String motherName) {
			super();
			this.eMRNo = eMRNo;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.setdOB(dOB);
			this.fatherName = fatherName;
			this.motherName = motherName;
		}
		public int geteMRNo() {
			return eMRNo;
		}
		public void seteMRNo(int eMRNo) {
			this.eMRNo = eMRNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public byte getAge() {
			return age;
		}
		public void setAge(byte age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		public String getFatherName() {
			return fatherName;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public String getMotherName() {
			return motherName;
		}
		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}
		public Date getdOB() {
			return dOB;
		}
		public void setdOB(Date dOB) {
			this.dOB = dOB;
		}
		
		
}
