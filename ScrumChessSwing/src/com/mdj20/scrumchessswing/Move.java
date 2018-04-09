package com.mdj20.scrumchessswing;

import com.scrumchess.gamelogic.AlgebraicNotation;
import com.scrumchess.gamelogic.FenUtility;
import com.scrumchess.gamelogic.RankAndFile;

public class Move implements AlgebraicNotation {
	
	String user;
	RankAndFile to;
	RankAndFile from;
	
	Move(String user){
		this(user,null,null);
	}
	Move(String user, RankAndFile from, RankAndFile to){
		this.user = user;
		this.from = from;
		this.to= to;
	}

	public String getUser() {
		return user;
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
