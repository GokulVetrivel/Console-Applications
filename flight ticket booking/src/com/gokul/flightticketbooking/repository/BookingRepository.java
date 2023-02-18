package com.gokul.flightticketbooking.repository;

import java.util.ArrayList;
import java.util.List;

import com.gokul.flightticketbooking.dto.Admin;
import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Credentials;
import com.gokul.flightticketbooking.dto.Flight;


public class BookingRepository {
	private static BookingRepository bookingDbInstance;

	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
//	private  library = null;
	private List<Booking> bookings = new ArrayList<Booking>();
	private List<Flight> flights = new ArrayList<Flight>();
	private Admin currentAdminUser = null;

	private BookingRepository() {  // private constructor for singleton class

	}
	
	public static BookingRepository getInstance() {
		if(bookingDbInstance==null) {
			bookingDbInstance=new BookingRepository();
			bookingDbInstance.initailSetup();
			bookingDbInstance.addFlights();
		}
		return bookingDbInstance;
	}

	private void initailSetup() {
		adminCredentials.add(new Credentials("0001", "admin", "ZSGS"));
		adminCredentials.add(new Credentials("0002", "gokul", "2506"));
	}
	
	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}
	
	private void addFlights() {
		Flight flight1=new Flight(701, "Coimbatore", "Chennai", 2);
		Flight flight2=new Flight(702, "Trichy   ", "Chennai", 10);
		Flight flight3=new Flight(703, "Tuticorin", "Chennai", 10);
		
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	
	public List<Booking> getBookings(){
		return bookings;
	}
	
	public boolean cancelBooking(int booking_id) {
		for(Booking booking:bookings) {
			if(booking.getBooking_id()==booking_id) {
				bookings.remove(booking);
				return true;
			}
		}
		return false;
	}
}
