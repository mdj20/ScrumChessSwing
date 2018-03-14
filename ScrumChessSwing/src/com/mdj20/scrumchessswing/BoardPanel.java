package com.mdj20.scrumchessswing;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mdj20.scrumchessswing.ajaxswingworkers.MoveSender;

public class BoardPanel extends JPanel {
	
	private Square squares[][] = new Square[8][8];
	private Color highlight = Color.YELLOW;
	private Square set ;
	private boolean isSquareSet = false;
	private Endpoint endpoint;

	BoardPanel(Endpoint ep){
		setLayout(new GridLayout(8,8));
		initSquares();
		this.endpoint = ep;
	}
	
	private void initSquares(){
		ArrayList<Square> squareList = new ArrayList<Square>();
		for (int i = 0 ; i < 8 ; i++){
			for (int j = 0 ; j< 8 ; j++){	
				if ((i+j)%2==0){
					Square s = bs(j,i,Color.GRAY);
					squares[i][j] = s;
					squareList.add(s);
				}
				else{
					Square s = bs(j,i,Color.WHITE);
					squares[i][j] = s;
					squareList.add(s);
				}
			}
		}
		for(Square s: squareList) {
			this.add(s);
		}	
	}
	
	private Square bs(int r, int f, Color c){
		return new Square(r,f,c,this);	
	}
	
	public Square getSquare(int x, int y){
		return squares[y][x];
	}

	public void setBoard(String fen, Map<String,String> pieceMap){
		int i=0;
		int j=0;
		for(char c : fen.toCharArray())	{
			if(pieceMap.containsKey(Character.toString(c))){
				JLabel label = this.getSquare(j,i).getjLabel();
				label.setText(pieceMap.get(Character.toString(c)));
				j++;
			}
			else if (Character.isDigit(c)){
				j+=Character.getNumericValue(c);
			}
			else if (c == '/'){
				i++;
				j=0;
			}
		}
	}
	
	public void squareClick(Square clicked){
		System.out.println();
		if(!this.isSquareSet){
			setSquare(clicked);
			highlightSquare(clicked);
			System.out.println("Set");
		}
		else if(this.isSquareSet  && clicked.equals(this.set)){
			System.out.println("Reclick");
			unHighLight(this.set);
			clearSquare();
		}
		else if(this.isSquareSet && !clicked.equals(this.set)){
			
		//	MoveSender ms = new MoveSender(endpoint,new Move("USER",this.set,clicked));
			//ms.execute();
			unHighLight(this.set);
			clearSquare();
			System.out.println("CLicked elsewhere");
			
		}
		else{
			System.out.println("Error");
		}
		
	}
		
	private boolean setSquare(Square s){
		boolean ret = false;
		if (this.isSquareSet == false){
			this.set = s;
			this.isSquareSet = true;
			ret = true;
		}
		return ret;
	}
	private void clearSquare(){
		this.isSquareSet = false;
	}
	
	private void highlightSquare(Square s){
		s.setBackground(highlight);
	}
	private void unHighLight(Square s){
		s.setBackground(s.getDefaultColor());
	}
	
	
	
	
}
