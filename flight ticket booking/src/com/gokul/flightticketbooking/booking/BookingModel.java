package com.gokul.flightticketbooking.booking;

import java.util.*;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;
import com.gokul.flightticketbooking.repository.BookingRepository;

public class BookingModel implements BookingModelCallBack {
	private BookingControllerModelCallBack bookingController;
	//private List<Booking> bookings=new ArrayList();
	//private FlightsIn flights=new FlightsIn();
	//private int booking_id=1000;
	
	public BookingModel(BookingController bookingController) {
		this.bookingController=bookingController;
	}

	public void addBooking(Booking booking) {
		if(bookingController.isAvailable(BookingRepository.getInstance().getBookings(),BookingRepository.getInstance().getFlights(),booking)) {
			//bookings.add(booking);
			BookingRepository.getInstance().addBooking(booking);
			bookingController.bookingSuccess("your booking is confirmed...\nBooking ID :"+booking.getBooking_id());
		}
		else
			bookingController.bookingFailed("Ticket not available..try another flight...");
	}

	public List<Booking> getBooking() {
		return BookingRepository.getInstance().getBookings();
	}
	
	public List<Flight> getFlights() {
		return BookingRepository.getInstance().getFlights();
	}
}
