package com.mdj20.scrumchessswing;

public class FenUtility {
	
	public static final String STARTING_FEN_SHORT = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

	// parses fen and return true if fen is valid, returns false if it is not.
	public static boolean checkFEN(String fen){  
		boolean ret = true;
		int i = 0;
		int l = 0;
		int slash = 0;
		for(char c :fen.toCharArray()){
			if(Character.isDigit(c)){
				i+=Character.getNumericValue(c);
			}
			else if (Character.isLetter(c)){
				l++;
			}
			else if (c == '/'){
				slash++;
			}
		}
		if(slash != 7){
			ret = false;
		}
		if(l+i != 64){
			ret = false;
		}
		return ret;
	}
	
	
}
