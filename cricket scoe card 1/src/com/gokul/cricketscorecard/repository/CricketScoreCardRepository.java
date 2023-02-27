package com.gokul.cricketscorecard.repository;

import java.util.ArrayList;
import java.util.List;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;

public class CricketScoreCardRepository {
	private static CricketScoreCardRepository cricketScoreCardRepository;
	private static Match match=new Match();
	private  static Score score1=new Score();
	private  static Score score2=new Score();
	
	private List<Score> scores=new ArrayList();
	private CricketScoreCardRepository (){
		
	}
	public static CricketScoreCardRepository getInstance() {
		if(cricketScoreCardRepository ==null) {
			return new CricketScoreCardRepository ();
		}
		else
			return cricketScoreCardRepository ;
	}
	public void matchDetails(int overs_v, String team1, String team2, String tossWon) {
		match.setOvers(overs_v);
		match.setTeam1(team1);
		match.setTeam2(team2);
		match.setTossWonBy(tossWon);
		
	}
	
	public Match getmatch() {
		return match;
	}
	public void updateScore(int run, int ball, int wicket) {
		//System.out.println(score1.getRun());
		score1.setRun(score1.getRun()+run);
		score1.setBall(score1.getBall()+ball);
		score1.setWicket(score1.getWicket()+wicket);
			
		}
	public void updateScore2(int run, int ball, int wicket) {
		//System.out.println(score2.getRun());
		score2.setRun(score2.getRun()+run);
		score2.setBall(score2.getBall()+ball);
		score2.setWicket(score2.getWicket()+wicket);
			
		}
	
	
	public Score getScore1() {
		return score1;
	}
	public Score getScore2() {
		return score2;
	}

}
