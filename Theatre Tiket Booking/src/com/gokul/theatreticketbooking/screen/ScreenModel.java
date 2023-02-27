package com.gokul.theatreticketbooking.screen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;
import com.gokul.theatreticketbooking.repository.TheatreRepository;

public class ScreenModel implements ScreenModelCallBack {
	private ScreenControllerModelCallBack sceenController;
	
	public ScreenModel(ScreenController screenController) {
		this.sceenController=screenController;
	}

//	public void addScreen(int id_v, int rows_v, int cols_v, int price_v, Date time1_v, Date time2_v, Date time3_v) {
//		TheatreRepository.getInstance().addScreen(id_v,rows_v,cols_v,price_v,time1_v,time2_v,time3_v);
//		
//	}
	public void addScreen(int id_v, int rows_v, int cols_v) {
		if(TheatreRepository.getInstance().addScreen(id_v,rows_v,cols_v))
			sceenController.addScreenSuccessMsg("Screen is added sucessfully...");
	}


	public List<Show> getShowDetails() {
		// TODO Auto-generated method stub
		return TheatreRepository.getInstance().getShowDetails();
	}

	public void addShow(int screenId_v, String movieName_v, int price_v, LocalTime showTime_v, LocalDate showDate_v) {
		// TODO Auto-generated method stub
		if(TheatreRepository.getInstance().addShow(screenId_v,movieName_v,price_v,showTime_v,showDate_v))
			sceenController.addShowSuccessMsg("show is added succesfully");
		else
			sceenController.addShowFailureMsg("screen id not exist");
	}

	public List<Screen> getScreens() {
		// TODO Auto-generated method stub
		return TheatreRepository.getInstance().getScreens();
	}

	@Override
	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		return TheatreRepository.getInstance().getBookings();
	}

	

	
}
