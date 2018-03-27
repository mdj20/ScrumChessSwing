package com.mdj20.scrumchessswing;

import com.scrumchess.gamelogic.MoveValidator;

public class BoardControl {
	MoveValidator moveValidator = new MoveValidator(FenUtility.STARTING_FEN_SHORT);
	
	
	
	public void setFromFen(String fen){
		moveValidator = new MoveValidator(fen);
	}
	
	public String getCurrentFen(){
		return moveValidator.getFen();
	}
}
