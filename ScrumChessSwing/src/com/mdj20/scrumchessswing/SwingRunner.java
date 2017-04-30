package com.mdj20.scrumchessswing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingRunner {
	
	public static void main(String args[]) throws InterruptedException{
		JFrame topLevel = new JFrame();
		BoardPanel boardPanel = new BoardPanel();
		topLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		topLevel.add(boardPanel);
		topLevel.pack();
		topLevel.setVisible(true);
		List<String> ucodes = Piece.getUnicodeStringsList();
		boardPanel.setBoard(FenUtility.STARTING_FEN_SHORT, Piece.getPieceKeyMap());

		Endpoint endpoint = new Endpoint();
		new Thread(endpoint).start();
		
		//Thread.sleep(2000);

		//endpoint.sendMove(new Move("User",boardPanel.getSquare(0, 0),boardPanel.getSquare(1, 1)));
		endpoint.sendMove(new Move("USER!"));
		
		for(int i = 0; i < 25 ; i++){
			//Move move = new Move("USER",boardPanel.getSquare(i%8,i/8),boardPanel.getSquare(7-(i%8), 7-(i/8)));
			//endpoint.sendMove(move);
			endpoint.sendMove(new Move(new StringBuilder().append("USER").append(Integer.toString(i)).toString()));
		}
		System.out.println("HERE!");
		endpoint.setRunning(false);
				
	}
	

	
	
}
