package com.mdj20.scrumchessswing.tansit.data;

public class SimpleGameIdentification implements GameIdentification {

	private String gameID;

	SimpleGameIdentification(String id){
		this.gameID = id;
	}
	
	/* (non-Javadoc)
	 * @see com.mdj20.scrumchessswing.tansit.data.GameIdentification#getGameID()
	 */
	@Override
	public String getGameID(){
		return gameID;
	}
	
}
