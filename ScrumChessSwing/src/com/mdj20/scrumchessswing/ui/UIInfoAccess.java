package com.mdj20.scrumchessswing.ui;

import com.scrumchess.gamelogic.RankAndFile;
import com.scrumchess.userrequests.GameConfiguration;

public interface UIInfoAccess extends UIUpdater{
	public GameConfiguration getNewGameConfig();
	public String getWhite();
	public String getBlack();
	public long getGameId();
}
