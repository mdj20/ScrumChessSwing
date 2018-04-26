package com.mdj20.scrumchessswing.ui;

import com.mdj20.scrumchessswing.backend.BackendAccess;
import com.mdj20.scrumchessswing.proxyuibackend.MainProxy;
import com.mdj20.scrumchessswing.ui.components.BoardPanel;
import com.mdj20.scrumchessswing.ui.components.InfoPanel;
import com.scrumchess.gamelogic.RankAndFile;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public class CentralUI implements CentralUIAccess{
	
	private BoardPanel boardPanel;
	private InfoPanel infoPanel;
	private BackendAccess mainProxy;
	
	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}
	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	@Override
	public void tryMove(final RankAndFile from, final RankAndFile to) {
		Move move = new Move(from,to);
		System.out.println(move.getAlabraicNotation());
		mainProxy.tryMove(new Move(from,to));
	}

	@Override
	public void newGame() {
		System.out.println("newGame");
		mainProxy.newGameOffline(this.getNewGameConfig());
	}
	
	@Override
	public void newGameOnline() {
		System.out.println("newgameOnline clicked");
	}
	
	@Override
	public void loadGame() {

		System.out.println( "loadgame clicked");
		
	}
	@Override
	public void cycleAI() {
		mainProxy.cycleAI();
	}


	@Override
	public NewGameConfig getNewGameConfig() {
		return infoPanel.getGameConfig();
	}

	@Override
	public String getWhite() {
		return infoPanel.getWhite();
	}

	@Override
	public String getBlack() {
		return infoPanel.getBlack();
	}

	@Override
	public long getGameId() {
		return infoPanel.getGameId();
	}

	@Override
	public void setGameConfig(NewGameConfig newGameConfig) {
		infoPanel.setGameConfig(newGameConfig);
	}

	@Override
	public void setBoard(String fen) {
		boardPanel.setBoard(fen);
		
	}

	@Override
	public void setWhite(String user) {
		infoPanel.setWhite(user);
	}

	@Override
	public void setBlack(String user) {
		infoPanel.setBlack(user);
	}

	@Override
	public void setGameId(long gameId) {
		infoPanel.setGameId(gameId);
	}

	@Override
	public void setBackendAccess(BackendAccess backendAccess) {
		this.mainProxy = backendAccess;
	}
	@Override
	public void setGameStatus(String status) {
		infoPanel.setGameStatus(status);
		
	}

}
