package com.mdj20.scrumchessswing.proxyuibackend;





import javax.swing.SwingUtilities;
import com.mdj20.scrumchessswing.backend.BackendAccess;
import com.mdj20.scrumchessswing.backend.GameControl;
import com.mdj20.scrumchessswing.ui.CentralUIAccess;
import com.mdj20.scrumchessswing.ui.Move;
import com.mdj20.scrumchessswing.ui.UIUpdater;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

/**Class serves as a thread barrier between game control and 
 * 
 * @author Matthew D. Jeffreys
 *
 */


public class MainProxy implements UIUpdater, BackendAccess{

	CentralUIAccess cuia;
	GameControl gameControl;
	
	
	@Override
	public void newGameOffline(NewGameConfig config) {
		
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

	@Override
	public void cycleAI() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				gameControl.cycleAi();
	
			}		
		}).start();
	}

	@Override
	public void gameLoad(long gameID) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setGameConfig(final NewGameConfig newGameConfig) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setGameConfig(newGameConfig);
			}
		});
	}

	@Override
	public void setBoard(final String fen) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setBoard(fen);
			}
		});
	}

	@Override
	public void setWhite(final String user) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setWhite(user);
			}
		});
	}

	@Override
	public void setBlack(final String user) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setBlack(user);
			}
		});
	}

	@Override
	public void setGameId(final long gameId) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setGameId(gameId);
			}
		});
		
	}



}
