package com.gokul.theatreticketbooking.screen;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;

public class ScreenView implements ScreenViewCallBack {
	private ScreenControllerViewCallBack screenController;
	private Scanner scan=new Scanner(System.in);
	public ScreenView(){
		screenController=new ScreenController(this);
	}

	public void create() {
		screenOptions();
		
	}

	private void screenOptions() {
		boolean bool=true;
		while (bool) {
		System.out.println("1.add SCREEN\n2.get Screens\n3.add Show\n4.Show Screen details\n5.get Bookings\n6.Back");
		int option=scan.nextInt();
		switch(option) {
		case 1:addScreen();
				break;
				
		case 2:getScreens();
				break;
				
		case 3:addShow();
				break;
			
		case 4:showDetails();
				break;
		
		case 5:getBookings();
				break;
		
		case 6:bool=false;
				break;
				
		default :System.err.println("enter valid option");
				
		}
		}
	}

	private void getBookings() {
		List<Booking> bookings=screenController.getBookings();
		for(Booking booking:bookings) {
			System.out.println("movie name :"+booking.getMovieName()+"\tsceen no :"+booking.getScreenId()+"\tShow time :"+booking.getShowTime()+"\tShow Date :"+booking.getshowDate());
		}
	}

	private void getScreens() {
		// TODO Auto-generated method stub
		List<Screen> screens=screenController.getScreens();
		for(Screen screen:screens)
			System.out.println("screen no :"+screen.getScreenId()+"\tseats :"+(screen.getColumnsCount()*screen.getRowsCount()));
		//screenOptions();
	}

	public void addShow() {
		System.out.println("enter screen No :");
		String screenId=scan.next();
		System.out.println("Enter movie name :");
		String movieName=scan.next();
		System.out.println("price/Ticket :");
		String price=scan.next();
		System.out.println("Show Start time (hh:mm) :");
		String showTime=scan.next();
		System.out.println("Show date (yyyy-MM-DD) :");
		String showDate=scan.next();
		screenController.addShow(screenId,movieName,price,showTime,showDate);
		//screenOptions();
	}
	public void addShowSuccessMsg(String msg) {
		System.out.println(msg);
		
	}
	
	public void addShowFailureMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
	
	
	private void showDetails() {
		List<Show> shows=screenController.getShowDetails();
		for(Show show :shows )
			System.out.println("Screen No :"+show.getScreenId()+"\tMovie Name :"+show.getMovieName()
					+"\tPrice/Ticket :"+show.getPrice()+"\t Show Date :"+show.getShowDate()+"\tShow time :"+show.getShowTime());
		//screenOptions();
	}

	public void addScreen() {
		System.out.print("Enter Screen number :");
		String screenId=scan.next();
		System.out.print("Enter no.of rows :");
		String rowsCount=scan.next();
		System.out.print("Enter no.of columns :");
		String columnsCount=scan.next();
		
		screenController.addScreen(screenId,rowsCount,columnsCount);
		//screenOptions();
	}

	public void addScreenSuccessMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		
	}
	
}
