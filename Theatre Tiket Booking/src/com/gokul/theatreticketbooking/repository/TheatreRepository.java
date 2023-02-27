package com.gokul.theatreticketbooking.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Admin;
import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Credentials;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;

public class TheatreRepository {
	private static TheatreRepository theatreInstance;
	private List<Credentials> adminCredentials=new ArrayList();
	private List<Screen> screens=new ArrayList();
	private List<Show> shows=new ArrayList();
	private List<Booking> bookings=new ArrayList();
	private TheatreRepository() {
		
	}
	public static  TheatreRepository getInstance() {
		if(theatreInstance==null) {
			theatreInstance= new TheatreRepository();
			theatreInstance.initialSetup();
		}
		return theatreInstance;
	}
	
	private void initialSetup() {
		adminCredentials.add(new Credentials("001","admin","ZSGS"));
		adminCredentials.add(new Credentials("002","gokul","ZSGS"));
		
		screens.add(new Screen(1,5,5));
		screens.add(new Screen(2,2,2));
		
	}
	public Admin checkForLogin(String userName, String password) {
		for(Credentials adminCredential:adminCredentials) {
			if(adminCredential.getUserName().equals(userName) && adminCredential.getPassword().equals(password)) {
				return adminCredential;
			}
		}
		
		return null;
	}
	public List<Screen> getScreens(){
		return screens;
	}
	public List<Show> getShowDetails() {
		// TODO Auto-generated method stub
		return shows;
	}
	public boolean addScreen(int id_v, int rows_v, int cols_v) {
		Screen screen=new Screen(id_v,rows_v,cols_v);
		screens.add(screen);
		return true;
	}
	public boolean addShow(int screenId_v, String movieName_v, int price_v, LocalTime showTime_v, LocalDate showDate_v) {
		Show show=new Show();
		for(Screen screen : screens) {
			if(screen.getScreenId()==screenId_v) {
				show.setScreenId(screenId_v);
				show.setMovieName(movieName_v);
				show.setPrice(price_v);
				show.setShowTime(showTime_v);
				show.setShowDate(showDate_v);
				show.setCapacity(screen.getColumnsCount()*screen.getRowsCount());
				shows.add(show);
				return true;
			}
		}
		return false;
		
	}
	public boolean addBooking(String movieName, int noOfSeats_v, int screenNo_v, LocalDate showDate_v,
			LocalTime showTime_v) {
		Booking booking = new Booking();
		
		booking.setScreenId(screenNo_v);
		booking.setMovieName(movieName);
		booking.setDate(showDate_v);
		booking.setShowTime(showTime_v);
		
		int booked=0,capacity=0;
		for(Booking b:bookings) {
			if(b.getScreenId()==screenNo_v && b.getshowDate().equals(showDate_v) && b.getShowTime().equals(showTime_v)) {
				booked++;
			}
		}
		for(Screen screen:screens) {
			if(screen.getScreenId()==screenNo_v) {
				capacity=screen.getColumnsCount()*screen.getRowsCount();
			}
		}
		for(Show show:shows){
		if(booked<capacity && show.getShowDate().equals(showDate_v)&& show.getShowTime().equals(showTime_v)) {
			bookings.add(booking);
			return true;
		}
		}
			return false;	
	}
	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		return bookings;
	}
}
