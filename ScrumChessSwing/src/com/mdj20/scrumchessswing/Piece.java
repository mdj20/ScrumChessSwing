package com.mdj20.scrumchessswing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
	
	public static final String FEN_PIECE_STRING = "kqrbnpKQRBNP";
	
	public static final String  KING_BLACK_STRING = "k";
	public static final String  QUEEN_BLACK_STRING = "q";
	public static final String  ROOK_BLACK_STRING = "r";
	public static final String  BISHOP_BLACK_STRING ="b";
	public static final String  KNIGHT_BLACK_STRING = "n";
	public static final String  PAWN_BLACK_STRING = "p";
	public static final String  KING_WHITE_STRING = "K";
	public static final String  QUEEN_WHITE_STRING = "Q";
	public static final String  ROOK_WHITE_STRING = "R";
	public static final String  BISHOP_WHITE_STRING = "B";
	public static final String  KNIGHT_WHITE_STRING = "N";
	public static final String  PAWN_WHITE_STRING = "P";
	public static final String  EMPTY_SPACE_STRING = "";
	
	public static final String KING_WHITE_UCODE = "\u2654";
	public static final String QUEEN_WHITE_UCODE = "\u2655";
	public static final String ROOK_WHITE_UCODE = "\u2656";
	public static final String BISHOP_WHITE_UCODE = "\u2657";
	public static final String KNIGHT_WHITE_UCODE = "\u2658";
	public static final String PAWN_WHITE_UCODE = "\u2659";
	public static final String KING_BLACK_UCODE = "\u265A";
	public static final String QUEEN_BLACK_UCODE = "\u265B";
	public static final String ROOK_BLACK_UCODE = "\u265C";
	public static final String BISHOP_BLACK_UCODE = "\u265D";
	public static final String KNIGHT_BLACK_UCODE = "\u265E";
	public static final String PAWN_BLACK_UCODE = "\u265F";

	
	public static List<String> getUnicodeStringsList(){
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String,String> map = getPieceKeyMap();
		for(char c: FEN_PIECE_STRING.toCharArray()){
			list.add(map.get(Character.toString(c)));
		}
		return list;
	}

	public static HashMap<String, String> getPieceKeyMap(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(KING_BLACK_STRING,KING_BLACK_UCODE);
		map.put(QUEEN_BLACK_STRING, QUEEN_BLACK_UCODE);
		map.put(BISHOP_BLACK_STRING, BISHOP_BLACK_UCODE);
		map.put(KNIGHT_BLACK_STRING, KNIGHT_BLACK_UCODE);
		map.put(ROOK_BLACK_STRING, ROOK_BLACK_UCODE);
		map.put(PAWN_BLACK_STRING, PAWN_BLACK_UCODE);
		map.put(KING_WHITE_STRING, KING_WHITE_UCODE);
		map.put(QUEEN_WHITE_STRING, QUEEN_WHITE_UCODE);
		map.put(BISHOP_WHITE_STRING, BISHOP_WHITE_UCODE);
		map.put(KNIGHT_WHITE_STRING, KNIGHT_WHITE_UCODE);
		map.put(ROOK_WHITE_STRING, ROOK_WHITE_UCODE);
		map.put(PAWN_WHITE_STRING, PAWN_WHITE_UCODE);
		map.put(EMPTY_SPACE_STRING,EMPTY_SPACE_STRING);
		return map;
	}
}
