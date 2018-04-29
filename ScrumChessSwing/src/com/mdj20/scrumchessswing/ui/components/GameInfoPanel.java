package com.mdj20.scrumchessswing.ui.components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class GameInfoPanel extends JPanel {
	
	CentralUIAccess centralUIAccess;
	GameStatusField gameStatusField = new GameStatusField(centralUIAccess);
	GameTypeSpinner gameTypeSpinner= new GameTypeSpinner();
	TurnTextField turnTextField = new TurnTextField();
	GameIdInputBox gameIdInputBox = new GameIdInputBox();;
	
	GameInfoPanel(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;
		GridLayout gridLayout = new GridLayout(4,1);
		this.setLayout(gridLayout);
		this.add(gameIdInputBox);
		this.add(gameTypeSpinner);
		this.add(gameStatusField);
		this.add(turnTextField);
	}

	
	
	
	
	
	
}
