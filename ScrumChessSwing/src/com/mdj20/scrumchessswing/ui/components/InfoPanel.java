package com.mdj20.scrumchessswing.ui.components;

import com.scrumchess.userrequests.NewGameRequest;

public interface InfoPanel {
	long getGameId();
	void setGameId(long gameId);
	public NewGameRequest.NewGameConfig getGameConfig();
	String getUser1();
	void setUser1(String user1);
	String getUser2();
	void setUser2(String user2);
}