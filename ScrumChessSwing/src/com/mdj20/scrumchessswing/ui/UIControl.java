package com.mdj20.scrumchessswing.ui;

import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.Move;
import com.mdj20.scrumchessswing.background.GameControl;
import com.mdj20.scrumchessswing.ui.workers.MoveExecuteWorker;
import com.scrumchess.gamelogic.FenUtility;
import com.scrumchess.gamelogic.MoveValidator;
import com.scrumchess.gamelogic.RankAndFile;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public class UIControl implements InfoPanel{
	BoardPanel boardPanel;
	InfoPanel mainInfoPanel;
	GameControl gameControl = new GameControl();
	
	public UIControl(BoardPanel bPanel, InfoPanel iPanel){
		this.boardPanel = bPanel;
		this.mainInfoPanel = iPanel;
	}
	
	public void setFromFen(String fen){
		gameControl = new GameControl(fen);
	}
	  
	public long getGameId() {
		return mainInfoPanel.getGameId();
	}
	
	public void setGameId(long id) {
		mainInfoPanel.setGameId(id);
	}
	
	
	public void tryMoveWorker(String user, RankAndFile from, RankAndFile to ) {
		Move move = new Move(user,from,to);
		MoveExecuteWorker worker = new MoveExecuteWorker(this,move);
		worker.execute();
	}
	
	public GameControl getGameControl() {
		return gameControl;
	}
	
	public void setBoardPanelUIThread(String fen) {
		String shortFen = FenUtility.getBoardFenSection(fen);
		if(FenUtility.checkFEN(shortFen)) {
			SwingUtilities.invokeLater(new BoardSetter(shortFen));
		}
	}
	
	public boolean tryMove(RankAndFile from, RankAndFile to) {
		return false;
	}
	
	/** Internal runnable class that calls setBoard
	 * 
	 * 
	 * @author Matthew D. Jeffreys
	 *
	 */
	
	class BoardSetter implements Runnable{
		String config;
		BoardSetter(String config){
			this.config = config;
		}
		@Override
		public void run() {
			boardPanel.setBoard(config);
		}	
	}

	@Override
	public String getUser1() {
		return mainInfoPanel.getUser1();
	}

	@Override
	public void setUser1(String user1) {
		mainInfoPanel.setUser1(user1);
		
	}

	@Override
	public String getUser2() {
		return mainInfoPanel.getUser2();
	}

	@Override
	public void setUser2(String user2) {
		mainInfoPanel.setUser2(user2);	
	}

	@Override
	public NewGameConfig getGameConfig() {
		return mainInfoPanel.getGameConfig();
	}
}
