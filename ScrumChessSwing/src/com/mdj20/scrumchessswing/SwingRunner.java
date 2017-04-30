package com.mdj20.scrumchessswing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class SwingRunner {
	
	public static void main(String args[]) throws InterruptedException{

		JFrame topLevel = new JFrame();
		
		BoardPanel topFrame = new BoardPanel();
		topLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		topLevel.add(topFrame);
		topLevel.pack();
		topLevel.setVisible(true);
		
		
		
		topFrame.getSquare(0,0).setBackground(Color.yellow);
		Thread.sleep(1000);
		topFrame.getSquare(0,0).setBackground(topFrame.getSquare(0,0).color);
		
				
	}
	
	private static Square bs(int r, int f, Color c){
		return new Square(r,f,c);	
	}
}
