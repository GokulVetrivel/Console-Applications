package com.gokul.theatreticketbooking.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
	private String movieName;
	private int noOfSeats;
	private int screenId;
	private String seatId;
	private LocalDate showdate;
	private LocalTime showTime;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public LocalDate getshowDate() {
		return showdate;
	}
	public void setDate(LocalDate showdate) {
		this.showdate = showdate;
	}
}
