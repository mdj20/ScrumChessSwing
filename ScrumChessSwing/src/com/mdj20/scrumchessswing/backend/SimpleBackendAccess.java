package com.mdj20.scrumchessswing.backend;

import com.mdj20.scrumchessswing.ui.Move;
import com.scrumchess.data.GameConfiguration;

public class SimpleBackendAccess implements BackendAccess {

	ScrumchessGameControl scrumchessGameControl;
	
	
	SimpleBackendAccess(ScrumchessGameControl scrumchessGameControl){
		this.scrumchessGameControl = scrumchessGameControl;
	}
	
	@Override
	public void newGameOffline(final GameConfiguration config) {
		new Thread( new Runnable() {
			@Override
			public void run() {
				scrumchessGameControl.newGameOffline(config);
			}
		}).start();
	}

	@Override
	public void tryMove(final Move move) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				scrumchessGameControl.tryMove(move);
			}
		}).start();
	}

	@Override
	public void newGame(GameConfiguration config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newGame(GameConfiguration config, String white, String black) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cycleAI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameLoad(long gameID) {
		// TODO Auto-generated method stub
		
	}

}
