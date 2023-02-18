package com.gokul.flightticketbooking.booking;

import java.util.List;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;

public interface BookingModelCallBack {

	void addBooking(Booking booking);

	List<Booking> getBooking();

	List<Flight> getFlights();

}
