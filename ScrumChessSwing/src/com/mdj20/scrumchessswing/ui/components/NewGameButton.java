package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class NewGameButton extends ScrumchessActionButton {

	NewGameButton(CentralUIAccess infoPanel){
		super(infoPanel,"NEW GAME");
	}
	
	@Override
	ActionListener getListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				centralUIAccess.newGame();
			}
		};
	}
}
