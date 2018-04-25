package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewGameJButton extends JButton {

	InfoPanel iPanel;
	
	NewGameJButton(InfoPanel infoPanel){
		this.iPanel = infoPanel;
	}
	
	private void addListener() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 
			}
		});
	}
	
	
	
}
