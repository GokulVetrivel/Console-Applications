package com.gokul.theatreticketbooking.booking;

import java.util.List;

import com.gokul.theatreticketbooking.dto.Show;

public interface BookingControllerViewCallBack {

	List<Show> getShows();

	void addBooking(String movieName, String noOfSeats, String screenNo, String showDate, String showTime);

}
