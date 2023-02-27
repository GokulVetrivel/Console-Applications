package com.gokul.cricketscorecard.setup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.gokul.cricketscorecard.score.ScoreView;
import com.gokul.cricketscorecard.setup.SetupView.setupController;

public class SetupView implements SetupViewCallBack {
	public interface setupController {

	}

	private Scanner scan=new Scanner(System.in);
	private SetupControllerViewCallBack setupController;
	
	public SetupView() {
		setupController=new SetupController(this);
	}
	
	public static void main(String[] args) {
		SetupView setupView=new SetupView();
		setupView.create();
	}

	private void create() {
		matchDetails();
		ScoreView scoreView=new ScoreView();
		scoreView.create();
	}

	public void matchDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter no.of Overs :");
		String overs=scan.next();
		System.out.println("Enter team 1 name :");
		String team1=scan.next();
		System.out.println("Enter team 2 name :");
		String team2=scan.next();
		String tossWon=tossWinner();
		
		
		setupController.matchDetails(overs,team1,team2,tossWon);
		
	}

	public String tossWinner() {
		// TODO Auto-generated method stub
		System.out.println("Enter first batting team :");
		String tossWon=scan.next();
		return tossWon;
		
	}

	
}
