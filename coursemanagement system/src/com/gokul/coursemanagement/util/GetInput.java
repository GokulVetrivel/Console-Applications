package com.gokul.coursemanagement.util;

import java.util.Scanner;

public class GetInput {
	
private static Scanner scanner = new Scanner(System.in);
	
	public static String getChoice(){
	     return scanner.next();
	}
	public static String getId() {
		return scanner.next();
	}
	public static String getPassword() {
		return scanner.next();
	}
	public static String getName() {
		return scanner.next();
	}
	public static String getEmailId() {
		return scanner.next();
	}
	public static String getPhoneNumber() {
		return scanner.next();
	}
	public static String getDate() {
		return scanner.next();
	}
	public static String getContent() {
		return  scanner.next();
	}
	public static String getSeats() {
		return scanner.next();
	}
	public static String getSkillSet() {
		return scanner.next();
	}
}
