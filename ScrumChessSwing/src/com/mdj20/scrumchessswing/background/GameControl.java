package com.mdj20.scrumchessswing.background;

import java.util.ArrayList;

import com.mdj20.scrumchessswing.Move;
import com.mdj20.scrumchessswing.ui.SquarePanel;
import com.mdj20.scrumchessswing.ui.UIControl; 
import com.mdj20.scrumchessswing.ui.UIUpdater;
import com.scrumchess.authentication.ScrumchessAuthenticationType;
import com.scrumchess.authentication.SimpleUserAuthenticationInfo;
import com.scrumchess.authentication.SimpleUserCredentials;
import com.scrumchess.data.Game;
import com.scrumchess.gamelogic.AIExecutor;
import com.scrumchess.gamelogic.FenUtility;
import com.scrumchess.gamelogic.SimpleAIExecutor;
import com.scrumchess.gamelogic.SimpleGameExecutor;
import com.scrumchess.userrequests.NewGameRequest;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;
import com.scrumchess.userrequests.NewGameResponse;
import com.scrumchess.userrequests.UserRequestHandler;

public class GameControl {
	
	Long gameId;
	boolean isBackend = false;
	NewGameConfig gameConfig;
	UserRequestHandler urHandler = new ScrumchessConnectionBuilder();
	SimpleUserCredentials user1Cred = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,"user1");
	String user1Name;
	ScrumchessAuthenticationType user1authtype = ScrumchessAuthenticationType.DEBUG; 
	String user2Name;
	ScrumchessAuthenticationType user2authtype = ScrumchessAuthenticationType.DEBUG; 
	SimpleUserCredentials user2Cred = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,"user2");
	AIExecutor aiExec = new SimpleAIExecutor();
	UIUpdater uiUpdater;
	UserCredentialHelper userCredentialHelper;

	public GameControl(){
		this(FenUtility.STARTING_FEN_LONG);
	}
	public GameControl(String fen){
		aiExec.startGameFromFen(fen);
	}
	
	public void updateUser1Token(String token) {
		if (!user1Name.equals(token)) {
			user1Name = token;
			user1Cred
		}
	}
	
	
	public boolean tryMove(Move move) {
		boolean ret = false;
		String an = move.getAlabraicNotation();
		System.out.println(an);
		if(aiExec.executeMove(move)) {
			ret = true;
		}
		return ret;
	}
	
	public void newGameBackend(NewGameConfig config) {
		NewGameRequest ngr = new NewGameRequest(new SimpleUserAuthenticationInfo<String>(getUser1Cred()),config,getUser2Name());
		NewGameResponse response = urHandler.tryNewGameRequest(ngr);
		if(response.isSuccessful()) {
			setFromGameObject(response.getResponseObject());
		}
		else {
			System.out.println(response.getRespnseFailureReason().toString());
		}
	}
	
	
	
	
		
	public int getEndgameState() {
		return aiExec.getGameStatus();
	}
	
	public String getFen() {
		return aiExec.getFen();
	}
	
	public String getShortFen() {
		return aiExec.getShortFen();
	}
	
	public void setFromGameObject(Game game) {
		aiExec.startGameFromFen(game.getFen());
		this.uiUpdater.setGameId(game.getId());
		if(game.isWhite()) {
			this.uiUpdater.setUserWhite(game.getWhite());
		}
		if(game.isBlack()) {
			this.uiUpdater.setUserBlack(game.getBlack());
		}
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
