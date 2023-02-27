package com.gokul.cricketscorecard.setup;

public class SetupController implements SetupControllerViewCallBack, SetupControllerModelCallBack {
	private SetupViewCallBack setupView;
	private SetupModelCallBack setupModel;
	
	public SetupController(SetupView setupView) {
		this.setupView=setupView;
		this.setupModel=new SetupModel(this);
	}

	public void matchDetails(String overs, String team1, String team2, String tossWon) {
		int overs_v = 0;
		try {
		  overs_v=Integer.parseInt(overs);
		}
		catch(Exception e) {
			System.err.println("enter valid overs...");
			setupView.matchDetails();
		}
		if(tossWon.equals(team1) || tossWon.equals(team2) ) {
			setupModel.matchDetails(overs_v,team1,team2,tossWon);
		}
		else {
			System.err.println("Enter name correctly...");
			setupView.tossWinner();
		}
	}

}
