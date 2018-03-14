package com.mdj20.scrumchessswing.tansit.data;

public class SimpleUserAuth implements UserAuth {
	
	public static final int AUTH_TYPE_GOOGLE = 1;
	
	private String token;
	private int authenticationType;
	
	
	public String getUserToken(){
		return token;
	}

	public int getAuthenticationType(){
		return authenticationType;
	}
	
}
