package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class CycleAIButton extends ScrumchessActionButton {

	CycleAIButton(CentralUIAccess centralUIAccess) {
		super(centralUIAccess);
	}
	
	private void addActionListener() {
		this.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centralUIAccess.cycleAI();
				
			}
		});
	}

}
