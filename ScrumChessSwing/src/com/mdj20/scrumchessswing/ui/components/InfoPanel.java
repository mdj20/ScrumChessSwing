package com.mdj20.scrumchessswing.ui.components;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;
import com.scrumchess.userrequests.NewGameRequest;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public interface InfoPanel {
	public long getGameId();
	public void setGameId(long gameId);
	public NewGameConfig getGameConfig();
	public void setGameConfig(NewGameConfig gameConfig);
	public String getWhite();
	public void setWhite(String user1);
	public String getBlack();
	public void setBlack(String user2);
	public void setTurnWhite();
	public void setTurnBlack();
	public CentralUIAccess getCentralUIAccess();
}