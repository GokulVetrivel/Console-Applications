package com.gokul.flightticketbooking.dto;

import java.util.*;

public class Booking {
	private String passengerName;
	private byte passengerAge;
	//private String gender;
	private int flightNo;
	private int booking_id;
	private Date date;
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(byte passengerAge) {
		this.passengerAge = passengerAge;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void displayBooking() {
		System.out.println("Passenger Name :"+passengerName+"\tPassenger Age :"+passengerAge+"\tFlight No :"+flightNo+"\tBooking Id :"+booking_id);
	}
	
}
