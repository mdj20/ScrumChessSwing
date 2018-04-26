package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class NewOnlineGameButton extends ScrumchessActionButton {

	NewOnlineGameButton(CentralUIAccess centralUIAccess) {
		super(centralUIAccess,"NEW GAME ONLINE");
	}

	private void addActionListener(){
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				centralUIAccess.newGameOnline();
			}
			
		});
	}

	@Override
	ActionListener getListener() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				centralUIAccess.newGameOnline();
			}
			
		};
	}
	
	
}
