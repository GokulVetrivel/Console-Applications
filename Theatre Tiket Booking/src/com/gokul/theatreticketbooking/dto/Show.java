package com.gokul.theatreticketbooking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Show extends Screen {
	private int screenId;
	private int price;
	private LocalTime showTime;
	private LocalDate showDate;
	private String movieName;
	private int capacity;
	private int availableSeats;
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}
