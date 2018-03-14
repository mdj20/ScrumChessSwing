package com.mdj20.scrumchessswing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Game {
	String gameID;
	String fen;
	int move;
	String black;
	String white;

	
	
	
	
	public static void main(String args[]){
		smokeTest();
	}
	
	public static void smokeTest(){
		Game game = new Game();
		game.black = "User2";
		game.white = "User1";
		game.move = 2;
		game.gameID = "hfjdkjfgjh";
		game.fen = "THIS IS FEN";
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(game));
		
		GsonBuilder gb = new GsonBuilder();
	
		
		
		
	}
}
