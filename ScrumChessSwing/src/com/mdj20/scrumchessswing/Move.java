package com.mdj20.scrumchessswing;

public class Move {
	
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
}
