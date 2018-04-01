package com.mdj20.scrumchessswing;

import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.ui.BoardPanel;
import com.mdj20.scrumchessswing.ui.MoveExecuteWorker;
import com.scrumchess.gamelogic.MoveValidator;

public class BoardControl {
	BoardPanel boardPanel;
	GameControl gameControl = new GameControl();
	
	public BoardControl(BoardPanel bPanel){
		boardPanel = bPanel;
	}
	
	public void setFromFen(String fen){
		gameControl = new GameControl(fen);
	}
	
	
	public void tryMoveWorker(String user, RankAndFile from, RankAndFile to ) {
		System.out.println("USER BC "+user);
		
		Move move = new Move(user,from,to);
		MoveExecuteWorker worker = new MoveExecuteWorker(this,move);
		worker.execute();
	}
	
	public GameControl getGameControl() {
		return gameControl;
	}
	
	public void setBoardPanelUIThread(String fen) {
		System.out.println("INSIDE: "+fen);
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
