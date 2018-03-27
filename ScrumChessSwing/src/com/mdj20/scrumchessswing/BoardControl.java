package com.mdj20.scrumchessswing;

import com.scrumchess.gamelogic.MoveValidator;

public class BoardControl {
	MoveValidator moveValidator = new MoveValidator(FenUtility.STARTING_FEN_SHORT);
	
	BoardPanel boardPanel;
	
	BoardControl(BoardPanel bPanel){
		boardPanel = bPanel;
	}
	
	public void setFromFen(String fen){
		moveValidator = new MoveValidator(fen);
	}
	
	public String getCurrentFen(){
		return moveValidator.getFen();
	}
	
	public int isEndGame() {
		return moveValidator.isEndGame();
	}
	
	public boolean tryMove(RankAndFile from, RankAndFile to) {
		String moveString = FenUtility.move(from.getFile(), from.getRank(), to.getFile(), to.getRank());
		moveValidator.setMove(moveString);
		return moveValidator.doMove();
	}
	
	public String getShortFen() {
		String split[] = moveValidator.getFen().split(" ");
		return split[0]; 
	}
}
