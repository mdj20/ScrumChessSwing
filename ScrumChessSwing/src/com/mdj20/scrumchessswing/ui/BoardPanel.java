package com.mdj20.scrumchessswing.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mdj20.scrumchessswing.BoardControl;
import com.mdj20.scrumchessswing.Endpoint;
import com.mdj20.scrumchessswing.RankAndFile;
import com.mdj20.scrumchessswing.ajaxswingworkers.MoveSender;

public class BoardPanel extends JPanel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1891085852783069906L;
	
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
	Map<String,String> pieceMap;
	BoardControl boardControl;

	BoardPanel(Endpoint ep, Map<String,String> pieceMap){
		setLayout(new GridLayout(8,8));
		this.pieceMap = pieceMap;
		initSquares();
		this.endpoint = ep;
	}
	
	private void initSquares(){
		ArrayList<SquarePanel> squareList = new ArrayList<SquarePanel>();
		for (int i = 7 ; i >= 0 ; i--){
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
	
	public SquarePanel getSquare(int x, int y){
		return squares[y][x];
	}

	public void setBoard(String fen){
		int i=7;
		int j=0;
		for(char c : fen.toCharArray())	{
			if(pieceMap.containsKey(Character.toString(c))){
				JLabel label = this.getSquare(j,i).getjLabel();
				label.setText(pieceMap.get(Character.toString(c)));
				j++;
			}
			else if (Character.isDigit(c)){
				int l = j+Character.getNumericValue(c);
				for(int k = j ; k < l; k++) {
					JLabel blankLabel = this.getSquare(j,i).getjLabel();
					blankLabel.setText(pieceMap.get(""));
				}
				j+=Character.getNumericValue(c);
				
			}
			else if (c == '/'){
				i--;
				j=0;
			}
		}
	}
	
	public void setPieceMap(Map<String,String> map) {
		this.pieceMap = map;
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
			this.boardControl.tryMoveWorker("test", this.set,clicked);
			clearSquare();
			System.out.println("CLicked elsewhere");
		}
		else{
			System.out.println("Error");
		}
	}
	
	void setBlackHighlight(RankAndFile from, RankAndFile to) {
		unsetBlackHighlight();
		blackToSet = getSquare(from.getRank(),from.getFile());
		blackFromSet =  getSquare(from.getRank(),from.getFile());
		setBorder(blackToSet,blacktTo);
		setBorder(blackFromSet,blackFrom);
	}

	void setWhiteHighlight(RankAndFile from, RankAndFile to) {
		unsetWhiteHighlight();
		whiteToSet = getSquare(from.getRank(),from.getFile());
		whiteFromSet =  getSquare(from.getRank(),from.getFile());
		setBorder(whiteToSet,whitetTo);
		setBorder(whiteFromSet,whiteFrom);
	}
	
	void unsetWhiteHighlight() {
		if (whiteToSet!= null) {
			setBorder(whiteToSet,emptyBorder);
			whiteToSet = null;
		}
		if(whiteFromSet!=null) {
			setBorder(whiteFromSet,emptyBorder);
			whiteFromSet = null;
		}
	}
	
	void unsetBlackHighlight() {
		if (blackToSet!= null) {
			setBorder(blackToSet,emptyBorder);
			blackToSet = null;
		}
		if(blackFromSet!=null) {
			setBorder(blackFromSet,emptyBorder);
			blackFromSet = null;
		}
	}
	
	
	void setBorder(SquarePanel s, Border border){
		s.setBorder(border);
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
	
	public void setBoardControl(BoardControl bc) {
		this.boardControl = bc;
	}
	
	
	
}
