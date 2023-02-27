package com.gokul.theatreticketbooking.screen;

import java.util.List;

import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;

public interface ScreenControllerViewCallBack {

	void addShow(String screenId, String movieName, String price, String showTime, String showDate);

	void addScreen(String screenId, String rowsCount, String columnsCount);

	List<Screen> getScreens();

	List<Show> getShowDetails();

	List<Booking> getBookings();

}
