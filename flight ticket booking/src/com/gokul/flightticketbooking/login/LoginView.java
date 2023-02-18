package com.gokul.flightticketbooking.login;

import java.util.Scanner;

import com.gokul.flightticketbooking.booking.BookingView;
import com.gokul.flightticketbooking.cancellation.CancellationView;
import com.gokul.flightticketbooking.dto.Admin;
//import com.gokul.flightticketbooking.flight.FlightsIn;


public class LoginView implements LoginViewCallBack {
	private LoginControllerViewCallBack loginController;
	private Scanner scan=new Scanner(System.in);
	
	public LoginView(){
		this.loginController=new LoginController(this);
	}
	
	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.create();
	}

	private void create() {
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("\n\t\tWELCOME TO THAMILAN AIRWAYS \n\t\t---------------------------");
		System.out.print("Enter User Name :");
		String userName = scan.next();
		System.out.print("Enter password :");
		String password = scan.next();
		loginController.checkCredentials(userName, password);
	}

	public void loginSuccess(Admin adminUser) {
		System.out.println("\nWelcome, " + adminUser.getUserName() + "...\n");
//		FlightsIn flightsIn=new FlightsIn();
//		flightsIn.create();
		BookingView bookingView=new BookingView();
		CancellationView cancellationView=new CancellationView();
		boolean bool=true;
		while(bool) {
		System.out.println("Enter appropriate option..\n1.Booking\n2.Cancellation\n3.close");
		int option=scan.nextInt();
		
		switch(option) {
		
		case 1:bookingView.create();
				break;
				
		case 2:cancellationView.create();
				break;
				
		case 3: bool=false;
				break;
				
		default :System.err.println("Enter valid key");
		
		}
		}
		
	}

	public void loginFailed(String errorMessage) {
		System.err.println(errorMessage);
		checkForLogin();
	}
}
