package com.gokul.flightticketbooking.booking;

import java.util.List;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;

public interface BookingControllerViewCallBack {

	List<Booking> getBooking();

	void addBooking(String name, byte age, int flightNo, int i, Booking booking);

	List<Flight> getFlights();

}
