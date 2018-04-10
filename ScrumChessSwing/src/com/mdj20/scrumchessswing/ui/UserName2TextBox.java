package com.mdj20.scrumchessswing.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class UserName2TextBox extends JTextField{

	MainInfoPanel mainInfoPanel;
	
	public UserName2TextBox(MainInfoPanel mainInfoPanel) {
		this.mainInfoPanel = mainInfoPanel;
		defaultKeyListener();
	}
	
	public void defaultKeyListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getSource() instanceof JTextField) {
					JTextField box = (JTextField) e.getSource(); 
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						if(box.getText().length()>0) {
							mainInfoPanel.requestFocus();
						}
						
					}
				}
		
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}		
		});
	}
}
