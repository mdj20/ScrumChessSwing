package com.mdj20.scrumchessswing;

import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.ui.BoardPanel;
import com.scrumchess.gamelogic.MoveValidator;

public class BoardControl {
	BoardPanel boardPanel;
	GameControl gameControl = new GameControl();
	
	BoardControl(BoardPanel bPanel){
		boardPanel = bPanel;
	}
	
	public void setFromFen(String fen){
		gameControl = new GameControl(fen);
	}
	
	
	public boolean tryMoveWorker(RankAndFile from, RankAndFile to ) {
		
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
	
	
}
