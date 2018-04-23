package com.mdj20.scrumchessswing.ui;

import javax.swing.SwingUtilities;

public class ScrumchessUIUpdater implements UIUpdater {
	
	BoardPanel boardPanel;
	InfoPanel infoPanel;

	ScrumchessUIUpdater(BoardPanel bp, InfoPanel ip){
		boardPanel = bp;
		infoPanel = ip;
	}
	
	@Override
	public void setBoard(final String fen) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				boardPanel.setBoard(fen);
			}
		});
	}

	@Override
	public void setUserWhite(final String user) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				infoPanel.setUser1(user);
			}
		});

	}

	@Override
	public void setUserBlack(final String user) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				infoPanel.setUser2(user);
			}
		});
	}

	@Override
	public void setGameId(final long gameId) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				infoPanel.setGameId(gameId);
			}
		});
	}

}
