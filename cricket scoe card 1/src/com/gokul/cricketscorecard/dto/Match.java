package com.gokul.cricketscorecard.dto;

public class Match {
	private int overs;
	private String team1;
	private String team2;
	private String tossWonBy;
	
	
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTossWonBy() {
		return tossWonBy;
	}
	public void setTossWonBy(String tossWonBy) {
		this.tossWonBy = tossWonBy;
	}
}
