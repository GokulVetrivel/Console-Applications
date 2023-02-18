package com.gokul.flightticketbooking.dto;

public class Flight {
	private int flightNo;
	private String fromCity;
	private String toCity;
	private int capacity;
	
	
	public Flight(int flightNo, String fromCity, String toCity, int capacity) {
		super();
		this.flightNo = flightNo;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.capacity = capacity;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void displayFlight() {
		System.out.println("Flight no :"+getFlightNo()+"\tDeparture From :"+fromCity+"\tDestination :"+toCity+"\tSeats :"+getCapacity());
		System.out.println();
	}
}
