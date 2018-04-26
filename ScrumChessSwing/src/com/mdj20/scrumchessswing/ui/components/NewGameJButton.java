package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class NewGameJButton extends ScrumchessActionButton {

	NewGameJButton(CentralUIAccess infoPanel){
		super(infoPanel);
		this.setText("NEW GAME");
		addListener();
	}
	
	private void addListener() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				centralUIAccess.newGame();
			}
		});
	}
}
