package com.mdj20.scrumchessswing.ui;

import com.scrumchess.gamelogic.AlgebraicNotation;
import com.scrumchess.gamelogic.FenUtility;
import com.scrumchess.gamelogic.RankAndFile;

public class Move implements AlgebraicNotation {
	
	RankAndFile to;
	RankAndFile from;
	

	public Move( RankAndFile from, RankAndFile to){
		this.from = from;
		this.to= to;
	}

	public RankAndFile getTo() {
		return to;
	}
	public RankAndFile getFrom() {
		return from;
	}
	
	public int getFromRank(){
		return from.getRank();
	}
	public int getToRank(){
		return to.getRank();
	}
	public int getFromFile(){
		return from.getFile();
	}
	public int getToFile(){
		return to.getFile();
	}
	@Override
	public String getAlabraicNotation() {
		return FenUtility.move(getFrom(), getTo());
	}
}
