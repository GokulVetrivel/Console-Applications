package com.gokul.theatreticketbooking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Screen {
	private int screenId;
	private int rowsCount;
	private int ColumnsCount;

	public Screen() {
		
	}
	public Screen(int screenId, int rowsCount, int columnsCount) {
		this.screenId=screenId;
		this.rowsCount=rowsCount;
		this.ColumnsCount=columnsCount;
		
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		rowsCount = rowsCount;
	}
	public int getColumnsCount() {
		return ColumnsCount;
	}
	public void setColumnsCount(int columnsCount) {
		ColumnsCount = columnsCount;
	}
	
}
