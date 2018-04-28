package com.mdj20.scrumchessswing.ui.components;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;
import com.scrumchess.userrequests.GameConfiguration;
import com.scrumchess.userrequests.NewGameRequest;

public interface InfoPanel {
	public long getGameId();
	public void setGameId(long gameId);
	public GameConfiguration getGameConfig();
	public void setGameConfig(GameConfiguration gameConfig);
	public String getWhite();
	public void setWhite(String user1);
	public String getBlack();
	public void setBlack(String user2);
	public void setTurnWhite();
	public void setTurnBlack();
	public void setGameStatus(String status);
	public CentralUIAccess getCentralUIAccess();
}