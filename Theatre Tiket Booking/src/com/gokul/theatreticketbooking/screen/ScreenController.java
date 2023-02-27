package com.gokul.theatreticketbooking.screen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;

public class ScreenController implements ScreenControllerViewCallBack, ScreenControllerModelCallBack {
	private ScreenViewCallBack screenView;
	private ScreenModelCallBack screenModel;
	
	public ScreenController(ScreenView screenView) {
		this.screenView=screenView;
		screenModel=new ScreenModel(this);
	}

	public void addScreen(String screenId, String rowsCount, String columnsCount) {
		try {
		int id_v=Integer.parseInt(screenId);
		int rows_v=Integer.parseInt(rowsCount);
		int cols_v=Integer.parseInt(columnsCount);
		screenModel.addScreen(id_v,rows_v,cols_v);
		}
		catch(Exception e) {
			System.err.println("enter valid input");
			screenView.addScreen();
		}
		
	}

	public List<Show> getShowDetails() {
		return screenModel.getShowDetails();
		
	}

	public void addShow(String screenId, String movieName, String price, String showTime, String showDate) {
		// TODO Auto-generated method stub
		
		try {
		int price_v=Integer.parseInt(price);
		LocalTime showTime_v=LocalTime.parse(showTime);
		LocalDate showDate_v=LocalDate.parse(showDate);
		String movieName_v=movieName;
		int screenId_v=Integer.parseInt(screenId);
		screenModel.addShow(screenId_v,movieName_v,price_v,showTime_v,showDate_v);
		}
		catch(Exception e) {
			System.err.println("enter valid input");
			screenView.addShow();
		}
	}

	public void addShowSuccessMsg(String msg) {
		// TODO Auto-generated method stub
		screenView.addShowSuccessMsg(msg);
	}

	public void addShowFailureMsg(String msg) {
		// TODO Auto-generated method stub
		screenView.addShowFailureMsg(msg);
	}

	public void addScreenSuccessMsg(String msg) {
		// TODO Auto-generated method stub
		screenView.addScreenSuccessMsg(msg);
	}

	public List<Screen> getScreens() {
		// TODO Auto-generated method stub
		return screenModel.getScreens();
	}

	@Override
	public List<Booking> getBookings() {
		return screenModel.getBookings();
	}

}
