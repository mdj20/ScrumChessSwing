package com.mdj20.scrumchessswing.ui;

import com.scrumchess.data.GameConfiguration;

public interface UIUpdater {
	public void setGameConfig(GameConfiguration gameConfiguration);
	public void setBoard(String fen);
	public void setWhite(String user);
	public void setBlack(String user);
	public void setGameId(long gameId);
	public void setGameStatus(String status);
}
