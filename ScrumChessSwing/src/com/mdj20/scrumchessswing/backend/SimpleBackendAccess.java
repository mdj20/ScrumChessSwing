package com.mdj20.scrumchessswing.backend;

import com.mdj20.scrumchessswing.ui.Move;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public class SimpleBackendAccess implements BackendAccess {

	GameControl gameControl;
	
	
	SimpleBackendAccess(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	@Override
	public void newGameOffline(final NewGameConfig config) {
		new Thread( new Runnable() {
			@Override
			public void run() {
				gameControl.newGameOffline(config);
			}
		}).start();
	}

	@Override
	public void tryMove(final Move move) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				gameControl.tryMove(move);
			}
		}).start();
	}

	@Override
	public void newGame(NewGameConfig config) {
		// TODO Auto-generated method stub

	}

}
