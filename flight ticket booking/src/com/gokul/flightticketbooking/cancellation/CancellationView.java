package com.gokul.flightticketbooking.cancellation;

import java.util.Scanner;

public class CancellationView implements CancellationViewCallBak {
	private Scanner scan=new Scanner(System.in);
	private int booking_id;
	private CancellationControllerViewCallBack cancellationController;
	
	public CancellationView(){
		this.cancellationController=new CancellationController(this);
	}
	
	public void cancelBooking() {
		System.out.println("Enter Booking Id :");
		booking_id=scan.nextInt();
		if(cancellationController.cancelBooking(booking_id))
			System.out.println("Booking has been cancelled");
		else
			System.err.println("Booking id is not exist");
	}

	public void create() {
		cancelBooking();
	}
	
}
