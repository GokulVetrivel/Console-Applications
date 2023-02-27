package com.gokul.cricketscorecard.score;

import com.gokul.cricketscorecard.dto.Match;
import com.gokul.cricketscorecard.dto.Score;

public interface ScoreModelViewCallBack {

	void updateScore(int i, int j, int k);

	Score getScore1();

	void updateScore2(int i, int j, int k);

	Score getScore2();

	Match getMatch();

}
