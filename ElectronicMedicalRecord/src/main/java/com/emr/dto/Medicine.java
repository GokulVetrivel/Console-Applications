package com.emr.dto;

public class Medicine {
	private int visitId;
	private String medicine;
	private String bfaf;
	private int morning;
	private int noon;
	private int night;
	private int days;
	public Medicine(int visitId, String medicine, String bfaf, int morning, int noon, int night, int days) {
		super();
		this.visitId = visitId;
		this.medicine = medicine;
		this.bfaf = bfaf;
		this.morning = morning;
		this.noon = noon;
		this.night = night;
		this.days = days;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getBfaf() {
		return bfaf;
	}
	public void setBfaf(String bfaf) {
		this.bfaf = bfaf;
	}
	public int getMorning() {
		return morning;
	}
	public void setMorning(int morning) {
		this.morning = morning;
	}
	public int getNoon() {
		return noon;
	}
	public void setNoon(int noon) {
		this.noon = noon;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	
}
