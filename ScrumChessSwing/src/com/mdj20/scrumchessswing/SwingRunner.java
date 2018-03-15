package com.mdj20.scrumchessswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingRunner {
	
	public static void main(String args[]) throws InterruptedException{
	
		final Endpoint endpoint = new Endpoint();
		new Thread(endpoint).start();
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				initGUI(endpoint);
			}
		});
	}
	
	private static void initGUI(Endpoint ep){
		JFrame topLevel = new JFrame();
		topLevel.setLayout(new BorderLayout());
		BoardPanel boardPanel = new BoardPanel(ep);
		topLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//boardPanel.setSize(new Dimension(800,800));
		topLevel.add(boardPanel);
		topLevel.pack();
		topLevel.setVisible(true);
		List<String> ucodes = Piece.getUnicodeStringsList();
		boardPanel.setBoard("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",  Piece.getPieceKeyMap());
		
		
		
	}
	
	
}
