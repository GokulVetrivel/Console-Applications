package com.gokul.cricketscorecard.score;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;

public interface ScoreControllerViewCallBack {

	void updateScore(String option);

	Score getScore1();

	void updateScore2(String option);

	Score getScore2();

	Match getMatch();

}
