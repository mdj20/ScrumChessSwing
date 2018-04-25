package com.mdj20.scrumchessswing.ui;

import com.scrumchess.gamelogic.RankAndFile;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public interface UIInfoAccess extends UIUpdater{
	public NewGameConfig getNewGameConfig();
	public String getWhite();
	public String getBlack();
	public long getGameId();
}
