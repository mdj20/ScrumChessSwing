package com.mdj20.scrumchessswing.ui.components;

import javax.swing.JTextField;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class GameStatusField extends JTextField {

	CentralUIAccess centralUIAccess;
	
	GameStatusField(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;
	}
	
}
