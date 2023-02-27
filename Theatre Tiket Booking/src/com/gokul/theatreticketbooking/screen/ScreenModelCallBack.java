package com.gokul.theatreticketbooking.screen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.gokul.theatreticketbooking.dto.Booking;
import com.gokul.theatreticketbooking.dto.Screen;
import com.gokul.theatreticketbooking.dto.Show;

public interface ScreenModelCallBack {

	void addScreen(int id_v, int rows_v, int cols_v);

	List<Show> getShowDetails();

	void addShow(int screenId_v, String movieName_v, int price_v, LocalTime showTime_v, LocalDate showDate_v);

	List<Screen> getScreens();

	List<Booking> getBookings();

}
