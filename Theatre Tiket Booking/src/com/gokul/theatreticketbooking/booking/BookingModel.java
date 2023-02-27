package com.gokul.theatreticketbooking.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Show;
import com.gokul.theatreticketbooking.repository.TheatreRepository;

public class BookingModel  {
	private BookingControllerModelCallBack bookingController;
	
	public BookingModel(BookingController bookingController) {
		this.bookingController=bookingController;
	}

	public void addBooking(String movieName, int noOfSeats_v, int screenNo_v, LocalDate showDate_v, LocalTime showTime_v) {
		// TODO Auto-generated method stub
		if(TheatreRepository.getInstance().addBooking(movieName,noOfSeats_v,screenNo_v,showDate_v,showTime_v))
			bookingController.addBookingSuccesMsg("Booking Added...");
		else
			bookingController.addBookingFailureMsg("house full...check your entry..");
	}

	public List<Show> getShows() {
		// TODO Auto-generated method stub
		return TheatreRepository.getInstance().getShowDetails();
	}
}
