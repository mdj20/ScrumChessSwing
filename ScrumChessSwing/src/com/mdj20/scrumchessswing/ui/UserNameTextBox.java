package com.mdj20.scrumchessswing.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class UserNameTextBox extends JTextField {

	/**
	 * 
	 */
	
	InfoPanel infoPanel;
	
	private static final long serialVersionUID = 7095685074397904505L;
	
	public UserNameTextBox(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
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
							infoPanel.setUser1(box.getText());
							infoPanel.requestFocus();
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
