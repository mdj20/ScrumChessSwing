package com.mdj20.scrumchessswing.backend;

import com.mdj20.scrumchessswing.ui.Move;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public interface BackendAccess {
	public void newGameOffline( NewGameConfig config);
	public void tryMove(Move move);
	public void newGame( NewGameConfig config);
	public void cycleAI();
	public void gameLoad(long gameID);
}
