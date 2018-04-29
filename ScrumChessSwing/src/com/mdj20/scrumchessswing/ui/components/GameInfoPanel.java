package com.mdj20.scrumchessswing.ui.components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class GameInfoPanel extends JPanel {
	
	CentralUIAccess centralUIAccess;
	GameStatusField gameStatusFeild;
	GameTypeSpinner gameTypeSpinner;
	TurnTextField turnTextField;
	GameIdInputBox gameIdInputBox;
	
	GameInfoPanel(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;
		GridLayout gridLayout = new GridLayout(4,1);
		this.setLayout(gridLayout);
		//gameIdInputBox = new GameId;
	}

	
	
	
}
