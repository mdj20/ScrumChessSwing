package com.mdj20.scrumchessswing;

import java.util.ArrayList;

import com.mdj20.scrumchessswing.ui.SquarePanel;
import com.scrumchess.gamelogic.MoveValidator;

public class GameControl {
	
	MoveValidator moveValidator = new MoveValidator(FenUtility.STARTING_FEN_LONG);
	ArrayList<Move> moveHistory = new ArrayList<Move>();
	
	
	
	GameControl(){
		this(FenUtility.STARTING_FEN_LONG);
	}
	GameControl(String fen){
		moveValidator = new MoveValidator(fen);
	}
	
	public boolean tryMove(Move move) {
		boolean ret = false;
		RankAndFile from = move.getFrom();
		RankAndFile to = move.getTo();
		String an = FenUtility.move(from, to);
		System.out.println(an);
		if(moveValidator.setAndDoMove(an)) {
			ret = true;
			moveHistory.add(move);
		}
		return ret;
	}
	
	public int getEndgameState() {
		return moveValidator.isEndGame();
	}
	
	public String getFen() {
		return moveValidator.getFen();
	}
	
	public static void main(String args[]) {
		GameControl gc = new GameControl();
		SquarePanel from = new SquarePanel(1, 4, null, null);
		SquarePanel to = new SquarePanel(3,4,null,null);
		Move move = new Move("user",from,to);
		System.out.print(gc.tryMove(move));
		System.out.println(gc.getFen());
	}
	
}
