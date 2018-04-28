package com.mdj20.scrumchessswing.ui;

import com.scrumchess.data.GameConfiguration;
import com.scrumchess.gamelogic.RankAndFile;

public interface UIInfoAccess extends UIUpdater{
	public GameConfiguration getNewGameConfig();
	public String getWhite();
	public String getBlack();
	public long getGameId();
}
