package com.mdj20.scrumchessswing;

import java.util.ArrayList;

import com.mdj20.scrumchessswing.ui.SquarePanel;
import com.scrumchess.authentication.ScrumchessAuthenticationType;
import com.scrumchess.authentication.SimpleUserAuthenticationInfo;
import com.scrumchess.authentication.SimpleUserCredentials;
import com.scrumchess.gamelogic.AIExecutor;
import com.scrumchess.gamelogic.FenUtility;
import com.scrumchess.gamelogic.MoveValidator;
import com.scrumchess.gamelogic.RankAndFile;
import com.scrumchess.gamelogic.SimpleAIExecutor;
import com.scrumchess.gamelogic.SimpleGameExecutor;
import com.scrumchess.userrequests.UserRequestHandler;

public class GameControl {
	
	UserRequestHandler urHandler = new ScrumchessConnectionBuilder();
	SimpleUserCredentials whiteUC = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,"user1");
	SimpleUserCredentials blackUC = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,"user2");
	MoveValidator moveValidator = new MoveValidator(FenUtility.STARTING_FEN_LONG);
	ArrayList<Move> moveHistory = new ArrayList<Move>();
	AIExecutor aiExec = new SimpleAIExecutor();
	
	public void setWhiteName(String white) {
		whiteUC = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,white);
	}
	public void setBlackName(String black) {
		blackUC = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,black);
	}
	
	
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
