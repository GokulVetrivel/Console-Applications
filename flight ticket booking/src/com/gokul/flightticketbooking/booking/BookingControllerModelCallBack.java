package com.gokul.flightticketbooking.booking;

import java.util.List;

import com.gokul.flightticketbooking.dto.Booking;
import com.gokul.flightticketbooking.dto.Flight;

public interface BookingControllerModelCallBack {

	boolean isAvailable(List<Booking> bookings, List<Flight> flights, Booking booking);

	void bookingSuccess(String string);

	void bookingFailed(String string);

}
