package com.mdj20.scrumchessswing.backend;

import com.mdj20.scrumchessswing.ui.Move;
import com.scrumchess.data.GameConfiguration;

public interface BackendAccess {
	public void newGameOffline( GameConfiguration config);
	public void tryMove(Move move);
	public void newGame( GameConfiguration config, String white, String black );
	public void cycleAI();
	public void gameLoad(long gameID);
}
