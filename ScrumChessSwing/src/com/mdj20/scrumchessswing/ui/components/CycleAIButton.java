package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class CycleAIButton extends ScrumchessActionButton {

	CycleAIButton(CentralUIAccess centralUIAccess) {
		super(centralUIAccess,"CYCLE AI");
		
	}

	@Override
	ActionListener getListener() {
		ActionListener ret = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				centralUIAccess.cycleAI();	
			}
		};
		return ret;
	}
	
	


}
