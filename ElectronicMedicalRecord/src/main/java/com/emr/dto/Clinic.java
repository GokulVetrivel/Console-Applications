package com.emr.dto;

public class Clinic {
	private int clinicId;
	private String clinicName;
	private String clinicAddress;
	private String clinicPhoneNo;
	private String eMailId;

	public Clinic(int clinicId, String clinicName, String clinicAddress, String clinicPhoneNo, String eMailId) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.clinicAddress = clinicAddress;
		this.clinicPhoneNo = clinicPhoneNo;
		this.eMailId = eMailId;
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

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getClinicPhoneNo() {
		return clinicPhoneNo;
	}

	public void setClinicPhoneNo(String clinicPhoneNo) {
		this.clinicPhoneNo = clinicPhoneNo;
	}

	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	@Override
	public String toString() {
		return "Clinic [clinicId=" + clinicId + ", clinicName=" + clinicName + ", clinicAddress=" + clinicAddress
				+ ", clinicPhoneNo=" + clinicPhoneNo + ", eMailId=" + eMailId + "]";
	}
	

}
