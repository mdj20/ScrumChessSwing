package com.mdj20.scrumchessswing;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mdj20.scrumchessswing.ajaxswingworkers.MoveSender;

public class BoardPanel extends JPanel {
	
	 SquarePanel squares[][] = new SquarePanel[8][8];
	 Color highlight = Color.YELLOW;
	 int borderThickness = 6;
	 Border whiteFrom = BorderFactory.createLineBorder(Color.RED, borderThickness);
	 Border whitetTo = BorderFactory.createLineBorder(Color.BLUE, borderThickness);
	 Border blackFrom = BorderFactory.createLineBorder(Color.GREEN, borderThickness);
	 Border blacktTo = BorderFactory.createLineBorder(Color.ORANGE, borderThickness);
	 Border emptyBorder = BorderFactory.createEmptyBorder();
	 SquarePanel whiteFromSet;
	 SquarePanel whiteToSet;
	 SquarePanel blackFromSet;
	 SquarePanel blackToSet;
	 SquarePanel set;
	 boolean isSquareSet = false;
	 Endpoint endpoint;

	BoardPanel(Endpoint ep){
		setLayout(new GridLayout(8,8));
		initSquares();
		this.endpoint = ep;
	}
	
	private void initSquares(){
		ArrayList<SquarePanel> squareList = new ArrayList<SquarePanel>();
		for (int i = 0 ; i < 8 ; i++){
			for (int j = 0 ; j< 8 ; j++){	
				if ((i+j)%2==0){
					SquarePanel s = new SquarePanel(i,j,Color.GRAY, this);
					squares[i][j] = s;
					squareList.add(s);
				}
				else{
					SquarePanel s = new SquarePanel(i,j,Color.WHITE, this);
					squares[i][j] = s;
					squareList.add(s);
				}
			}
		}
		for(SquarePanel s: squareList) {
			this.add(s);
		}	
	}
	
	private Square bs(int r, int f, Color c){
		return new Square(r,f,c,this);	
	}
	
	public SquarePanel getSquare(int x, int y){
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
	
	public void squareClick(SquarePanel clicked){
		System.out.println();
		if( !this.isSquareSet ){  // no square is set
			setSquare(clicked);
			highlightSquare(clicked);
			System.out.println("Set");
		}
		else if( this.isSquareSet  && clicked.equals(this.set)){ //set square is re-clicked
			System.out.println("Reclick");
			unHighLight(this.set);
			clearSquare();
		}
		else if( this.isSquareSet && !clicked.equals(this.set) ){  // another square is clicked.
			unHighLight(this.set);
			unSetBorders();
			setToBorder(this.set,whiteHightlightTo);
			setFromBorder(clicked,borderHightlightFrom);
			clearSquare();
			System.out.println("CLicked elsewhere");
		}
		else{
			System.out.println("Error");
		}
		
	}
	
	
	boolean setFromBorder(SquarePanel s, Border border){
		if(borderFromSet==null){
			s.setBorder(border);
			borderFromSet = s;
			return true;
		}
		else
			return false;
	}
	
	boolean setToBorder(SquarePanel s, Border border){
		if(borderToSet==null){
			s.setBorder(border);
			borderToSet = s;
			return true;
		}
		else
			return false;
	}
	
	/*
	boolean setMoveBorder(int fromx, int fromy, int tox, int toy){
		unSetBorders();
		return setFromBorder(getSquare(fromx,fromy),fromBorder(tox,toy));
	}
	*/
		
	void unSetBorders(){
		if(borderToSet!=null){
			borderToSet.setBorder(emptyBorder);
			borderToSet=null;
		}
		if(borderFromSet!=null){
			borderFromSet.setBorder(emptyBorder);
			borderFromSet = null;
		}
	}
	
	boolean unSetBorderSquare(SquarePanel unSet){
		
	}
	
	private boolean setSquare(SquarePanel s){
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
	
	private void highlightSquare(SquarePanel s){
		s.setBackground(highlight);
	}
	private void unHighLight(SquarePanel s){
		s.setBackground(s.getNormalColor());
	}
	
	
	
	
}
