package com.mdj20.scrumchessswing.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.ui.CentralUIAccess;
import com.mdj20.scrumchessswing.ui.UIInfoAccess;
import com.scrumchess.userrequests.NewGameRequest.NewGameConfig;

public class MainInfoPanel extends JPanel implements InfoPanel {

	private String user1;
	private String user2;
	private long gameId = 0;
	private CentralUIAccess centralUIAccess;
	
	JButton buttons[] ;
	JSpinner gameConfigSpinner = new GameTypeSpinner(); 
	TurnTextField turnTextField = new TurnTextField();
	JButton newGameButton = new JButton("NEW GAME BACK");
	JButton jButton1 = new JButton("Button 1");
	JButton jButton2 = new JButton("Button 2");
	JButton jButton3 = new JButton("Button 3");
	JButton jButton4 = new JButton("Button 4");
	GameIdInputBox gameBox =  new GameIdInputBox(this);
	
	UserNameTextBox userNameTextBox = new UserNameTextBox(this);
	UserName2TextBox userName2TextBox = new UserName2TextBox(this);
	
	public MainInfoPanel(CentralUIAccess uIControl ){
		this.centralUIAccess = uIControl;
		uIControl.setInfoPanel(this);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		NameTextArea nte = new NameTextArea(this);
		nte.setText("THIS IS THE TEXT");
		this.add(nte);
		this.add(userNameTextBox);
		this.add(userName2TextBox);
		createButtons(5);
		addButtons(buttons);
		this.add(gameConfigSpinner)	;
		addPrintListener(buttons[0]);
		this.add(gameBox);
		this.add(turnTextField);
		ButtonPanel buttonPanel = new ButtonPanel(centralUIAccess);
		this.add(buttonPanel);
	}
	

	
	@Override
	public long getGameId() {
		return Long.parseLong(gameBox.getText());
	}
	
	@Override
	public void setGameId(final long gameId) {
		gameBox.setText(Long.toString(gameId));
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
	
	
	@Override
	public String getWhite() {
		return userNameTextBox.getText();
	}


	@Override
	public void setWhite(final String user1) {
		userNameTextBox.setText(user1);
	}


	@Override
	public String getBlack() {
		return userName2TextBox.getText();
	}


	@Override
	public void setBlack(final String user2) {
			userName2TextBox.setText(user2);
	}
	

	
	private void addPrintListener(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				printInfo();
			}
		});
	}
	
	public void printInfo() {
		System.out.println("gameid: "+getGameId()+"\n"+getWhite()+" "+getBlack());
	}

	@Override
	public NewGameConfig getGameConfig() {
		return NewGameConfig.valueOf((String)gameConfigSpinner.getValue());
	}

	@Override
	public void setGameConfig(NewGameConfig gameConfig) {
		gameConfigSpinner.setValue(gameConfig);
	}

	@Override
	public void setTurnWhite() {
		turnTextField.setWhite();
	}

	@Override
	public void setTurnBlack() {
		turnTextField.setBlack();
	}



	@Override
	public CentralUIAccess getCentralUIAccess() {
		return centralUIAccess;
	}
	
}
