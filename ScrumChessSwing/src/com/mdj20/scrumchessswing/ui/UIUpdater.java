package com.mdj20.scrumchessswing.ui;

import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public interface UIUpdater {
	public void setGameConfig(NewGameConfig newGameConfig);
	public void setBoard(String fen);
	public void setWhite(String user);
	public void setBlack(String user);
	public void setGameId(long gameId);
	public void setGameStatus(String status);
}
