package com.mdj20.scrumchessswing.ui.components;

import javax.swing.JButton;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class ScrumchessActionButton extends JButton {

	protected CentralUIAccess centralUIAccess;
	
	ScrumchessActionButton(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;
	}
	
	
}
