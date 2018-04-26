package com.mdj20.scrumchessswing.proxyuibackend;





import javax.swing.SwingUtilities;
import com.mdj20.scrumchessswing.backend.BackendAccess;
import com.mdj20.scrumchessswing.backend.GameControl;
import com.mdj20.scrumchessswing.ui.CentralUIAccess;
import com.mdj20.scrumchessswing.ui.Move;
import com.mdj20.scrumchessswing.ui.UIUpdater;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

/**Class serves as a thread barrier between game control and UI.
 * 
 * @author Matthew D. Jeffreys
 *
 */


public class MainProxy implements UIUpdater, BackendAccess{

	private CentralUIAccess cuia;
	private GameControl gameControl;
	
	
	public MainProxy(CentralUIAccess cuia, GameControl gameControl){
		this.cuia = cuia;
		cuia.setBackendAccess(this);
		this.gameControl = gameControl;
		gameControl.setUiupdator(this);	
	}
	
	
	@Override
	public void newGameOffline(final NewGameConfig config) {
		new Thread (new Runnable() {
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
				gameControl.tryMoveAndUpdate(move);
			}		
		}).start();
	}

	@Override
	public void newGame(NewGameConfig config, String white, String black) {
		System.out.println("NEW GAME NOT IMPLEMENTED");
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

	@Override
	public void setGameStatus(final String status) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cuia.setGameStatus(status);
			}
		});
	}
}
