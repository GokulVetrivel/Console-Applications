package com.gokul.bankingapplication.util;

import java.util.Scanner;

public class GetInput {
	static private Scanner scan = new Scanner(System.in);
	
	public static int getInt() {
		return scan.nextInt();
	}
	
	public static String getString() {
		return scan.next();
	}
}
