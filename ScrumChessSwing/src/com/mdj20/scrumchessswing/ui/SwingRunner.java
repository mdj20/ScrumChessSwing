package com.mdj20.scrumchessswing.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.mdj20.scrumchessswing.backend.GameControl;
import com.mdj20.scrumchessswing.proxyuibackend.MainProxy;
import com.mdj20.scrumchessswing.ui.components.BoardPanel;
import com.mdj20.scrumchessswing.ui.components.MainInfoPanel;
import com.mdj20.scrumchessswing.ui.components.Piece;


public class SwingRunner {
	
	public static void main(String args[]) throws InterruptedException{
		
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				initGUI();
			}
		});
	}
	
	private static void initGUI(){
		JFrame topLevel = new JFrame();
		topLevel.setLayout(new GridBagLayout());
		CentralUI centralUI  = new CentralUI();
		BoardPanel boardPanel = new BoardPanel(centralUI,Piece.getPieceKeyMap());
		topLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainInfoPanel info = new MainInfoPanel(centralUI);
		GameControl gameControl = new GameControl();
		MainProxy mainProxy = new MainProxy(centralUI,gameControl);
		//boardPanel.setSize(new Dimension(800,800));
		topLevel.add(boardPanel,boardConstraints());
		topLevel.add(info,infoConstraints());
		topLevel.pack();
		topLevel.setVisible(true);
		info.setBackground(Color.GREEN);
		List<String> ucodes = Piece.getUnicodeStringsList();
		boardPanel.setBoard("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
	}
	
	private static GridBagConstraints boardConstraints() {
		GridBagConstraints ret = new GridBagConstraints();
		ret.anchor = GridBagConstraints.CENTER;
		ret.gridx = 1;
		ret.gridy = 0;
		ret.weighty = 1.0;
		ret.weightx = .5;	
		return ret;
	}
	
	private static GridBagConstraints infoConstraints() {
		GridBagConstraints ret = new GridBagConstraints();
		ret.anchor = GridBagConstraints.CENTER;
		ret.gridwidth = 1;
		ret.fill = GridBagConstraints.BOTH;
		ret.gridx = 2;
		ret.gridy = 0;
		ret.weighty = 1.0;
		ret.weightx = 1.0;	
		return ret;
	}

}
