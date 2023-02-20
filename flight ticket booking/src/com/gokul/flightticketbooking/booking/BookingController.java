package com.gokul.flightticketbooking.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;

public class BookingController implements BookingControllerViewCallBack, BookingControllerModelCallBack {
	private BookingViewCallBack bookingView;
	private BookingModelCallBack bookingModel;

	public BookingController(BookingView bookingView) {
		this.bookingView = bookingView;
		this.bookingModel = new BookingModel(this);
	}

	public void addBooking(String name, String gender, byte age, int flightNo, int booking_id,
			Booking booking) {
		booking.setPassengerName(name);
		booking.setGender(gender);
		booking.setPassengerAge(age);
		booking.setFlightNo(flightNo);
		booking.setBooking_id(booking_id);
		boolean bool = true;
		while (bool) {
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(bookingView.getDate());
				booking.setTravelDate(date);
				bool = false;
			} catch (Exception parseexception) {
				System.err.println("Enter Valid date");
			}
			
		}

		bookingModel.addBooking(booking);
	}

	public List<Booking> getBooking() {
		return bookingModel.getBooking();

	}

	public boolean isAvailable(List<Booking> bookings, List<Flight> flights, Booking booking) {
		int capacity = 0;
		for (Flight flight : flights) {
			if (flight.getFlightNo() == booking.getFlightNo())
				capacity = flight.getCapacity();
		}

		int booked = 0;
		for (Booking b : bookings) {
			if (b.getFlightNo() == booking.getFlightNo() && b.getTravelDate().compareTo(booking.getTravelDate()) == 0)
				booked++;
		}
		return booked < capacity ? true : false;
	}

	public void bookingFailed(String message) {
		bookingView.bookingFailed(message);

	}

	public void bookingSuccess(String message) {
		bookingView.bookingSuccess(message);
	}

	public List<Flight> getFlights() {
		// System.out.println(bookingModel.getFlights());
		return bookingModel.getFlights();
	}

}
