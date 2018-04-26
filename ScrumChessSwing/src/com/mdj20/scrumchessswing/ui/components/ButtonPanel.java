package com.mdj20.scrumchessswing.ui.components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class ButtonPanel extends JPanel {

	CentralUIAccess centralUIAccess;
	
	ButtonPanel(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;	
		GridLayout gridLayout = new GridLayout(1,5);
		CycleAIButton cia = new CycleAIButton(centralUIAccess);
		NewGameJButton newGameButton = new NewGameJButton(centralUIAccess);
		this.add(cia);
		this.add(newGameButton);
	}
	
	
}
