package com.mdj20.scrumchessswing.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.UIControl;

public class MainInfoPanel extends JPanel implements InfoPanel {

	private String user1;
	private String user2;
	private long gameId = 0;
	private UIControl uIControl;
	
	JButton buttons[] ;
	JSpinner gameConfigSpinner = new JSpinner() ; 
	JButton newGameButton = new JButton("NEW GAME BACK");
	JButton jButton1 = new JButton("Button 1");
	JButton jButton2 = new JButton("Button 2");
	JButton jButton3 = new JButton("Button 3");
	JButton jButton4 = new JButton("Button 4");
	GameIdInputBox gameBox =  new GameIdInputBox(this);
	
	UserNameTextBox userNameTextBox = new UserNameTextBox(this);
	UserName2TextBox userName2TextBox = new UserName2TextBox(this);
	
	MainInfoPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(userNameTextBox);
		this.add(userName2TextBox);
		createButtons(5);
		addButtons(buttons);
		addPrintListener(buttons[0]);
		//JFormattedTextField gameBox = new JFormattedTextField();
		//gameBox.setFormatter(GameIdInputBox.buildLongFormatter());
		this.add(gameBox);
	}
	
	public void setUiControl(UIControl uic) {
		this.uIControl = uic;
	}
	
	
	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#getGameId()
	 */
	@Override
	public long getGameId() {
		return Long.parseLong(gameBox.getText());
	}

	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#setGameId(long)
	 */
	@Override
	public void setGameId(final long gameId) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				gameBox.setText(Long.toString(gameId));
			}
		};
		SwingUtilities.invokeLater(r);
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
	
	
	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#getUser1()
	 */
	
	@Override
	public String getUser1() {
		return userNameTextBox.getText();
	}

	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#setUser1(java.lang.String)
	 */
	
	@Override
	public void setUser1(final String user1) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				userNameTextBox.setText(user1);
			}
		};
		SwingUtilities.invokeLater(r);
	}

	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#getUser2()
	 */
	
	@Override
	public String getUser2() {
		return userName2TextBox.getText();
	}

	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.ui.InfoPanel#setUser2(java.lang.String)
	 */
	
	@Override
	public void setUser2(final String user2) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				userName2TextBox.setText(user2);
			}
		};
		SwingUtilities.invokeLater(r);
	}
	
	private void addPrintListener(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				printInfo();
			}
		});
	}
	
	public void printInfo() {
		System.out.println("gameid: "+getGameId()+"\n"+getUser1()+" "+getUser2());
	}
	
}
