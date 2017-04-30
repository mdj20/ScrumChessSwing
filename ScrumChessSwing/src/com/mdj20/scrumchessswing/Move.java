package com.mdj20.scrumchessswing;

public class Move {
	

	String user;
	Square to;
	Square from;
	
	Move(String user){
		this(user,null,null);
	}
	Move(String user, Square from, Square to){
		this.user = user;
		this.from = from;
		this.to= to;
	}

	public String getUser() {
		return user;
	}
	public Square getTo() {
		return to;
	}
	public Square getFrom() {
		return from;
	}
}
