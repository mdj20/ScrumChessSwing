package com.mdj20.scrumchessswing.ui;

public interface UIUpdater {
	public void setBoard(String fen);
	public void setUserWhite(String user);
	public void setUserBlack(String user);
	public void setGameId(long gameId);
}
