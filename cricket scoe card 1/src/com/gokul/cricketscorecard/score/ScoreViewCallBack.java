package com.gokul.cricketscorecard.score;

public interface ScoreViewCallBack {

	void updateScore();

	void inningsOverMsg(String msg);

	void matchResultmsg(String msg);

}
