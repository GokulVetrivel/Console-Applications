package com.gokul.flightticketbooking.booking;

public interface BookingViewCallBack {

	void bookingFailed(String message);

	void bookingSuccess(String message);

}
