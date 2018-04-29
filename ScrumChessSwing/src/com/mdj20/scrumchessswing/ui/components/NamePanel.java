package com.mdj20.scrumchessswing.ui.components;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;

public class NamePanel extends JPanel {
	
	CentralUIAccess centralUIAccess;
	JTextField white;
	JTextField black;
	NamePanel(CentralUIAccess centralUIAccess){
		this.centralUIAccess = centralUIAccess;
		GridLayout gridLayout = new GridLayout(4,1);
		JLabel whiteLabel = new JLabel("White User Name");
		white = new JTextField();
		JLabel blackLabel = new JLabel("Black User Name");
		black = new JTextField();
		this.setLayout(gridLayout);
		this.add(whiteLabel);
		this.add(white);
		this.add(blackLabel);
		this.add(black);
	}
	
	public String getWhite(){
		return white.getText();
	}
	public String getBlack(){
		return black.getText();
	}
	public void setWhite(String white){
		this.white.setText(white);
	}
	public void setBlack(String black){
		this.black.setText(black);
	}
}
