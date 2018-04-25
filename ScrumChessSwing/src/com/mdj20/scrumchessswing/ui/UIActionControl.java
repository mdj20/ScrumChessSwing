package com.mdj20.scrumchessswing.ui;

import com.scrumchess.gamelogic.RankAndFile;

/** Interface defines a class that will accept all UI actions.
 * 
 * 
 * 
 * @author Matthew D. Jeffreys
 *
 */


public interface UIActionControl {
	public void tryMove(RankAndFile from, RankAndFile to);
	public void newGame();   
	public void loadGame();
	public void cycleAI();
	// button actions
}
