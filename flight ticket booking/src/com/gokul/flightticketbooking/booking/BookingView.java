package com.gokul.flightticketbooking.booking;

import java.util.List;
import java.util.Scanner;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;

public class BookingView implements BookingViewCallBack {
	private Scanner scan = new Scanner(System.in);
	private BookingControllerViewCallBack bookingController;
	private int booking_id=1000;
	public BookingView() {
		this.bookingController=new BookingController(this);
	}
	public void showFlights() {
		System.out.println("\t\tOur Premium Flight services\n\t\t---------------------------");
		for(Flight flight:bookingController.getFlights())
			System.out.println("Flight No :"+flight.getFlightNo()+"\tStarts from :"+flight.getFromCity()+"\tDestination:"+flight.getToCity()+"\tSeats :"+flight.getCapacity());
	}
	
	public void create() {
		showFlights();
		boolean bool=true;
		while(bool) {
		System.out.println("\n\t\tBooking Module\n\t\t--------------\nEnter appropriate options\n1.add Booking\n2.show Bookings\n3.back");
		int option=scan.nextInt();
		switch(option) {
		case 1:addBooking();
				break;
		case 2:getBookings();
				break;
				
		case 3:bool=false;
				break;
		default:System.err.println("Enter valid option");
		}
		}
	}

	private void getBookings() {
		List<Booking> bookings= bookingController.getBooking();
		for(Booking booking: bookings) {
			System.out.println("Booking Id :"+booking.getBooking_id()+"\tPassenger Name :"+booking.getPassengerName()+"\tPassenger Age :"+booking.getPassengerAge()+"\tGender :"+booking.getGender()+"\tFlight No :"+booking.getFlightNo()+"\tTravel Date :"+booking.getTravelDate());
		}
	}
	public String getDate() {
		System.out.println("Enter travel date (dd/mm/yyyy):");
		String travel_Date=scan.next();
		return travel_Date;
	}
	private void addBooking() {
		System.out.print("Enter passenger name :");
		String name=scan.next();
		System.out.print("Gender :");
		String gender=scan.next();
		System.out.print("Enter passenger age :");
		byte age=scan.nextByte();
		System.out.print("enter FlightNo :");
		int flightNo=scan.nextInt(); 
		Booking booking =new Booking();
		bookingController.addBooking(name,gender,age,flightNo,booking_id++,booking);
	}

	public void bookingFailed(String message) {
		System.err.println(message);
	}

	public void bookingSuccess(String message) {
		System.out.println(message);
	}

}
