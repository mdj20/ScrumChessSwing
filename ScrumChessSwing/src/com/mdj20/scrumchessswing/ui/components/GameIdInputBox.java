package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class GameIdInputBox extends JFormattedTextField {
	
	NumberFormatter formatter = new NumberFormatter();
	MainInfoPanel mainInfoPanel;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5303331757078319524L;

	GameIdInputBox(){
		super(buildLongFormatter());
		defaultKeyListener();
	}
	
	
	
	
	
	public static NumberFormatter buildLongFormatter() {
		 NumberFormat format = NumberFormat.getInstance();
		 format.setGroupingUsed(false);	
		    NumberFormatter formatter = new NumberFormatter(format);
		    formatter.setValueClass(Long.class);
		    formatter.setMinimum(0L);
		    formatter.setMaximum(Long.MAX_VALUE);
		    formatter.setAllowsInvalid(false);
		    // If you want the value to be committed on each keystroke instead of focus lost
		    formatter.setCommitsOnValidEdit(true);
		return formatter;
	}
	
	public void defaultKeyListener() {
		final GameIdInputBox con = this;
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
							con.getParent().requestFocus();
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
