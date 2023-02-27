package com.gokul.cricketscorecard.score;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;
import com.gokul.cricketscorecard.repository.CricketScoreCardRepository;

public class ScoreModel implements ScoreModelViewCallBack {
	private ScoreControllerModelCallBack scoreController;
	
	public ScoreModel(ScoreController scoreController) {
		this.scoreController=scoreController;
	}

	public void updateScore(int run, int ball, int wicket) {
		// TODO Auto-generated method stub
		if(CricketScoreCardRepository.getInstance().getmatch().getOvers() > CricketScoreCardRepository.getInstance().getScore1().getBall()/6 && CricketScoreCardRepository.getInstance().getScore1().getWicket()<10) {
		CricketScoreCardRepository.getInstance().updateScore(run,ball,wicket);
		}
		else
			scoreController.inningsOverMsg("Fist innings over");
	}
	
	public Score getScore1() {
		Score score=CricketScoreCardRepository.getInstance().getScore1();
		return score;
	}

	public void updateScore2(int run, int ball, int wicket) {
		if(CricketScoreCardRepository.getInstance().getmatch().getOvers() > CricketScoreCardRepository.getInstance().getScore2().getBall()/6 && CricketScoreCardRepository.getInstance().getScore2().getWicket()<10) {
			
			CricketScoreCardRepository.getInstance().updateScore2(run,ball,wicket);
			if(CricketScoreCardRepository.getInstance().getScore1().getRun()< CricketScoreCardRepository.getInstance().getScore2().getRun())
				scoreController.matchResultmsg(CricketScoreCardRepository.getInstance().getmatch().getTeam2()+" wins the match");
			
			}
			else
				scoreController.matchResultmsg(CricketScoreCardRepository.getInstance().getmatch().getTeam1()+" wins the match");

		
	}
	public Score getScore2() {
		Score score= CricketScoreCardRepository.getInstance().getScore2();
		return score;
	}
	
	public Match getMatch() {
		Match match=CricketScoreCardRepository.getInstance().getmatch();
		return match;
	}
}
