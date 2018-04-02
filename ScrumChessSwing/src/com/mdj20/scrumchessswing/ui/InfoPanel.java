package com.mdj20.scrumchessswing.ui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	private String user1;
	private String user2;
	
	JButton buttons[] ;
	JButton jButton0 = new JButton("Button 0");
	JButton jButton1 = new JButton("Button 1");
	JButton jButton2 = new JButton("Button 2");
	JButton jButton3 = new JButton("Button 3");
	JButton jButton4 = new JButton("Button 4");
	
	UserNameTextBox userNameTextBox = new UserNameTextBox(this);
	UserName2TextBox userName2TextBox = new UserName2TextBox(this);
	
	InfoPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(userNameTextBox);
		this.add(userName2TextBox);
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
	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
		System.out.println("user1: "+user1);
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
		System.out.println("user2: "+user2);
	}
}
