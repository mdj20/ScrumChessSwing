package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public abstract class ScrumchessActionButton extends JButton {

	protected CentralUIAccess centralUIAccess;
	protected String buttonText;
	
	ScrumchessActionButton(CentralUIAccess centralUIAccess,String buttonText){
		this.centralUIAccess = centralUIAccess;
		this.setText(buttonText);
		this.addActionListener(getListener());
	}
	
	abstract ActionListener getListener();
	

}
