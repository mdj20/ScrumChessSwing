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
import com.scrumchess.data.GameConfiguration;

public class MainInfoPanel extends JPanel implements InfoPanel {

	private String user1;
	private String user2;
	private long gameId = 0;
	private CentralUIAccess centralUIAccess;
	
	
	JSpinner gameConfigSpinner = new GameTypeSpinner(); 
	TurnTextField turnTextField = new TurnTextField();
	GameStatusField gameStatusField = new GameStatusField(centralUIAccess);
	NamePanel namePanel = new NamePanel(centralUIAccess);
	GameInfoPanel gameInfoPanel = new GameInfoPanel(centralUIAccess);

	
	public MainInfoPanel(CentralUIAccess uIControl ){
		this.centralUIAccess = uIControl;
		uIControl.setInfoPanel(this);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(namePanel);
		this.add(gameInfoPanel);
		ButtonPanel buttonPanel = new ButtonPanel(centralUIAccess);
		this.add(buttonPanel);
	}
	

	
	@Override
	public long getGameId() {
		return Long.parseLong(gameInfoPanel.gameIdInputBox.getText());
	}
	
	@Override
	public void setGameId(final long gameId) {
		System.out.println("GameID "+gameId);
		gameInfoPanel.gameIdInputBox.setText(Long.toString(gameId));
	}

	@Override
	public String getWhite() {
		return namePanel.getWhite();
	}


	@Override
	public void setWhite(String user1) {
		namePanel.setWhite(user1);
	}


	@Override
	public String getBlack() {
		return namePanel.getBlack();
	}


	@Override
	public void setBlack(final String user2) {
		namePanel.setBlack(user2);
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
	public GameConfiguration getGameConfig() {
		return (GameConfiguration) gameInfoPanel.gameTypeSpinner.getValue();
	}

	@Override
	public void setGameConfig(GameConfiguration gameConfig) {
		gameInfoPanel.gameTypeSpinner.setValue(gameConfig);
	}

	@Override
	public void setTurnWhite() {
		gameInfoPanel.turnTextField.setWhite();
	}

	@Override
	public void setTurnBlack() {
		gameInfoPanel.turnTextField.setBlack();
	}

	@Override
	public CentralUIAccess getCentralUIAccess() {
		return centralUIAccess;
	}

	@Override
	public void setGameStatus(String status) {
		gameInfoPanel.gameStatusField.setText(status);
	}
	
}
