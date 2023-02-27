package com.gokul.theatreticketbooking.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Show;

public class BookingController implements BookingControllerModelCallBack, BookingControllerViewCallBack {
	private BookingView bookingView;
	private BookingModel bookingModel;
	public BookingController(BookingView bookingView) {
		// TODO Auto-generated constructor stub
		this.bookingView =bookingView;
		bookingModel = new BookingModel(this);
	}
	public void addBooking(String movieName, String noOfSeats, String screenNo, String showDate, String showTime) {
		//try {
		String movieName_v=movieName;
		int noOfSeats_v=Integer.parseInt(noOfSeats);
		int screenNo_v=Integer.parseInt(screenNo);
		LocalDate showDate_v=LocalDate.parse(showDate);
		LocalTime showTime_v=LocalTime.parse(showTime);
		bookingModel.addBooking(movieName_v,noOfSeats_v,screenNo_v,showDate_v,showTime_v);
//		}
//		catch(Exception e){
//			System.err.println("enter valid input");
//			bookingView.addBooking();
//		}
//		
		
	}
	public void addBookingSuccesMsg(String msg) {
		// TODO Auto-generated method stub
		bookingView.addBookingSuccessMsg(msg);
	}
	public void addBookingFailureMsg(String msg) {
		// TODO Auto-generated method stub
		bookingView.addBookingFailureMsg(msg);
	}
	public List<Show> getShows() {
		// TODO Auto-generated method stub
		return bookingModel.getShows();
	}

}
