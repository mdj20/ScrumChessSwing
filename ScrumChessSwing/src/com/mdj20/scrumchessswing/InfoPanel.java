package com.mdj20.scrumchessswing;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	
	JButton buttons[] ;
	
	JButton jButton0 = new JButton("Button 0");
	JButton jButton1 = new JButton("Button 1");
	JButton jButton2 = new JButton("Button 2");
	JButton jButton3 = new JButton("Button 3");
	JButton jButton4 = new JButton("Button 4");
	
	
	InfoPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		createButtons(5);
		addButtons(buttons);
	}
	
	private void addButtons(JButton but[]) {
		for(JButton jb: but) {
			this.add(jb);
		}
	}
	
	private void createButtons(int n) {
		buttons = new JButton[n];
		for(int i = 0 ; i< n ; i++) {
			buttons[i] = new JButton("Button "+i);
		}
	}
	
}
