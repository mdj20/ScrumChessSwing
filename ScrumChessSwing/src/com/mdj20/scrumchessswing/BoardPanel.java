package com.mdj20.scrumchessswing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	private Square squares[][] = new Square[8][8];
	
	BoardPanel(){
		super();
		super.setLayout(new GridLayout(8,8));
		initSquares();
	}
	
	private void initSquares(){
		for (int i = 0 ; i < 8 ; i++){
			for (int j = 0 ; j< 8 ; j++){	
				if ((i+j)%2==0){
					Square s = bs(j,i,Color.gray);
					s.setWidthAndColor();
					squares[j][i] = s;
					this.add(s);
				}
				else{
					Square s = bs(j,i,Color.white);
					s.setWidthAndColor();
					squares[j][i] = s;
					this.add(s);
				}
			}
		}
	}
	private static Square bs(int r, int f, Color c){
		return new Square(r,f,c);	
	}
	
	public Square getSquare(int rank, int file){
		return squares[file][rank];
	}

}
