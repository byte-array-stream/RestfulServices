package com.asynchronous.resource;

public class ScoreBoardService {

	public ScoreBoard scoreBoard(String matchId) {

		ScoreBoard scoreCard = new ScoreBoard();
		scoreCard.setMatchNo(matchId);
		scoreCard.setTeam1("India");
		scoreCard.setTeam2("South Africa");
		scoreCard.setMatchType("Test");
		scoreCard.setInning(1);

		return scoreCard;
	}
}
