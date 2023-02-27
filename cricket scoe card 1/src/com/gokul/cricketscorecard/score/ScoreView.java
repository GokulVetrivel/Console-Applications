package com.gokul.cricketscorecard.score;

import java.util.Scanner;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;

public class ScoreView implements ScoreViewCallBack {
	private Scanner scan = new Scanner(System.in);
	private ScoreControllerViewCallBack scoreController;
	private boolean bool1 = true;
	private boolean bool2 = true;

	public ScoreView() {
		scoreController = new ScoreController(this);
	}

	public void create() {
		System.out.println("******Score card management*****");
		updateScore();
	}

	public void updateScore() {
		//getting 1st innings score
		while (bool1) {
			System.out.println("enter runs \n7.wide\n8.no ball \n9.wicket");
			String option = scan.next();
			scoreController.updateScore(option);
			Score score1 = scoreController.getScore1();
			System.out.println(scoreController.getMatch().getTeam1()+"\n---\nscore\t:" + score1.getRun() + "/" + score1.getWicket() + "\novers\t:"
					+ score1.getBall() / 6 + "." + score1.getBall() % 6);
		}
		//getting 2nd innings score
		while (bool2) {
			System.out.println("\n2nd innings\nenter runs \n7.wide\n8.no ball \n9.wicket");
			String option = scan.next();
			scoreController.updateScore2(option);
			Score score2 = scoreController.getScore2();
			System.out.println( scoreController.getMatch().getTeam2()+"\n---\nscore\t:" + score2.getRun() + "/" + score2.getWicket() + "\novers\t:"
					+ score2.getBall() / 6 + "." + score2.getBall() % 6);
		}
	}

	public void inningsOverMsg(String msg) {
		// TODO Auto-generated method stub
		bool1 = false;
		System.err.println(msg);

	}

	public void matchResultmsg(String msg) {
		bool2 = false;
		System.err.println(msg);
	}
}
