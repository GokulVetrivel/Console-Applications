package com.gokul.cricketscorecard.setup;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;
import com.gokul.cricketscorecard.repository.CricketScoreCardRepository;

public class SetupModel implements SetupModelCallBack {
	
	private SetupController setupController;
	
	public SetupModel(SetupController setupController) {
		this.setupController=setupController;
	}

	public void matchDetails(int overs_v, String team1, String team2, String tossWon) {
		CricketScoreCardRepository.getInstance().matchDetails(overs_v,team1,team2,tossWon); 
	}
	
}
