package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class LoadGameButton extends ScrumchessActionButton {

	LoadGameButton(CentralUIAccess centralUIAccess) {
		super(centralUIAccess,"LOAD GAME");
	}

	@Override
	ActionListener getListener() {
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				centralUIAccess.loadGame();
			}
		};
	}

	
	
	
}
