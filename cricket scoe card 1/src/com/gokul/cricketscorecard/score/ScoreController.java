package com.gokul.cricketscorecard.score;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;

public class ScoreController implements ScoreControllerModelCallBack, ScoreControllerViewCallBack {
	private ScoreViewCallBack scoreView;
	private ScoreModelViewCallBack scoreModel;
	
	public ScoreController(ScoreView scoreView) {
		this.scoreView=scoreView;
		scoreModel = new ScoreModel(this);
	}

	public void updateScore(String option) {
		// TODO Auto-generated method stub
		int opt=0;
		try {
		opt=Integer.parseInt(option);
		}
		catch(Exception e) {
			System.out.println("enter valid number...");
			scoreView.updateScore();
		}
		switch(opt) {
			
			case 0:scoreModel.updateScore(0,1,0);
					break;
				
			case 1:scoreModel.updateScore(1,1,0);
					break;
				
			case 2:scoreModel.updateScore(2,1,0);
					break;
				
			case 3:scoreModel.updateScore(3,1,0);
					break;
				
			case 4:scoreModel.updateScore(4,1,0);
					break;
				
			case 5:scoreModel.updateScore(5,1,0);
					break;
				
			case 6:scoreModel.updateScore(6,1,0);
					break;
				
			case 7:scoreModel.updateScore(1,0,0);
					break;
				
			case 8:scoreModel.updateScore(1,0,0);
					break;
				
			case 9:scoreModel.updateScore(0,1,1);
					break;
				
				
			default:System.out.println("unauthenticated ball...");
					scoreView.updateScore();
		}
		
	}
	
	public Score getScore1() {
		return scoreModel.getScore1();
	}
	

	public void inningsOverMsg(String msg) {
		scoreView.inningsOverMsg(msg);
		
	}

	public void updateScore2(String option) {
		// TODO Auto-generated method stub
		int opt=0;
		try {
		opt=Integer.parseInt(option);
		}
		catch(Exception e) {
			System.out.println("enter valid number...");
			scoreView.updateScore();
		}
		switch(opt) {
			
			case 0:scoreModel.updateScore2(0,1,0);
					break;
				
			case 1:scoreModel.updateScore2(1,1,0);
					break;
				
			case 2:scoreModel.updateScore2(2,1,0);
					break;
				
			case 3:scoreModel.updateScore2(3,1,0);
					break;
				
			case 4:scoreModel.updateScore2(4,1,0);
					break;
				
			case 5:scoreModel.updateScore2(5,1,0);
					break;
				
			case 6:scoreModel.updateScore2(6,1,0);
					break;
				
			case 7:scoreModel.updateScore2(1,0,0);
					break;
				
			case 8:scoreModel.updateScore2(1,0,0);
					break;
				
			case 9:scoreModel.updateScore2(0,1,1);
					break;
				
				
			default:System.out.println("unauthenticated ball...");
					scoreView.updateScore();
				
		}
		
		
	}
	public Score getScore2() {
		return scoreModel.getScore2();
	}

	public void matchResultmsg(String msg) {
		scoreView.matchResultmsg(msg);
		
	}
	
	public Match getMatch() {
		return scoreModel.getMatch();
	}

}
