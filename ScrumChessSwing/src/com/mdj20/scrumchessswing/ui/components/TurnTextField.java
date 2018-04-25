package com.mdj20.scrumchessswing.ui.components;

import javax.swing.JSpinner;
import javax.swing.JTextField;

public class TurnTextField extends JTextField {
	public void setWhite() {
		this.setText("WHITE");
	}
	public void setBlack() {
		this.setText("BLACK");
	}
}
