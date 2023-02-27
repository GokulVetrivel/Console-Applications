package com.gokul.theatreticketbooking.booking;

import java.util.Scanner;

import com.gokul.theatreticketbooking.dto.Show;

public class BookingView implements BookingViewCallBack {
	private Scanner scan=new Scanner(System.in);
	BookingControllerViewCallBack bookingController;
	
	public BookingView() {
		bookingController =new BookingController(this);
	}
	public void create() {
		addBooking();
	}
	
	
	private void getShows() {
		for(Show show:bookingController.getShows())
			System.out.println("Screen No :"+show.getScreenId()+"\tMovie Name :"+show.getMovieName()
			+"\tPrice/Ticket :"+show.getPrice()+"\t Show Date :"+show.getShowDate()+"\tShow time :"+show.getShowTime()+"\tseats :"+show.getCapacity());;
		
	}
	public void addBooking() {
		getShows();
		System.out.println("\t\t\tBooking Page\n\t\t\t------------");
		
		System.out.print("Enter movie name :");
		String movieName=scan.next();
		System.out.print("Enter no.of tickets :");
		String noOfSeats=scan.next();
		System.out.print("Enter screen no :");
		String screenNo=scan.next();
//		System.out.print("Enter seat");
//		String movieName=scan.next();
		System.out.println("Enter show Date(yyyy-mm-dd) :");
		String showDate=scan.next();
		System.out.println("Enter show time(hh:mm) :");
		String showTime=scan.next();
		
		bookingController.addBooking(movieName,noOfSeats,screenNo,showDate,showTime);
	}
	public void addBookingSuccessMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		
	}
	public void addBookingFailureMsg(String msg) {
		// TODO Auto-generated method stub
		System.err.println(msg);
	}
}
