package com.gokul.theatreticketbooking.login;

import java.util.Scanner;

import com.gokul.theatreticketbooking.booking.BookingView;
import com.gokul.theatreticketbooking.dto.Admin;
import com.gokul.theatreticketbooking.screen.ScreenView;

public class AdminLoginView implements AdminLoginViewCallBack {
	private Scanner scan=new Scanner(System.in);
	private AdminLoginControllerViewCallBack adminLoginController ;
	
	AdminLoginView(){
		adminLoginController=new AdminLoginController(this);
	}
	public static void main(String[] args) {
		System.out.println("\t\t\tKARASINGAM A/C MULTIPLEX\n\t\t\t------------------------");
		AdminLoginView adminLoginView = new AdminLoginView();
		//adminLoginController.onCreate();
		adminLoginView.create();
	}
	private void create() {
		checkForLogin();
		
	}
	private void checkForLogin() {
		System.out.print("Enter user name :");
		String userName=scan.next();
		System.out.print("password :");
		String password=scan.next();
		adminLoginController.checkForLogin(userName,password);
	}
	public void successLoginMsg(Admin user) {
		System.out.println("hi "+user.getUserName()+",");
		mainPage();
	}
		private void mainPage() {
		boolean bool=true;
		
		while(bool) {
		System.out.println("1.Manage Screen\n2.book ticket\n3.Close");
		int option=scan.nextInt();
		switch(option) {
		case 1:ScreenView screenView =new ScreenView();
				screenView.create();
				break;
			
		case 2:BookingView bookingView=new BookingView();
				bookingView.create();
				break;
			
		case 3:bool=false;
			break;
			
		default :System.err.println("enter valid option");
		
		}
		}
		
		
	}
	public void failedLoginMsg() {
		System.err.println("\nuser name and password not matching...\n");
		checkForLogin();
	}
}
