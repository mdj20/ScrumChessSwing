package com.mdj20.scrumchessswing.ui.components;

import javax.swing.JTextArea;

public class NameTextArea extends JTextArea {

	private final static int y = 1;
	private final static int x = 25;
	private InfoPanel iPanel;
	
	NameTextArea(InfoPanel iPanel) {
		super(y,x);
		this.iPanel = iPanel;
	}
	
	
}
