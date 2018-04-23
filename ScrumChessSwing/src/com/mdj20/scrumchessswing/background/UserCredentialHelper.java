package com.mdj20.scrumchessswing.background;

import com.scrumchess.authentication.ScrumchessAuthenticationType;
import com.scrumchess.authentication.SimpleUserCredentials;
import com.scrumchess.gamelogic.AIExecutor;
import com.scrumchess.gamelogic.SimpleAIExecutor;

public class UserCredentialHelper {
	
	String whiteToken;
	String blackToken;	
	ScrumchessAuthenticationType whiteAuthType = ScrumchessAuthenticationType.DEBUG; 
	ScrumchessAuthenticationType blackAuthType = ScrumchessAuthenticationType.DEBUG; 
	SimpleUserCredentials whiteCred; 
	SimpleUserCredentials blackCred; 
	
	UserCredentialHelper(String white, String black){
		 whiteToken = white;
		 blackToken = black;
		 whiteCred = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,white);
		 blackCred = new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,black);
	}
	
	
	public void setWhiteToken(String whiteToken) {
		if(!whiteToken.equals(this.whiteToken)) {
			this.whiteToken = whiteToken;
			whiteCred = new SimpleUserCredentials(whiteAuthType,this.whiteToken);
		}
	}


	public void setBlackToken(String blackToken) {
		if(!blackToken.equals(this.blackToken)) {
			this.blackToken = blackToken;
			blackCred = new SimpleUserCredentials(whiteAuthType,this.blackToken);
		}
	}


	public void setWhiteAuthType(ScrumchessAuthenticationType whiteAuthType) {
		this.whiteAuthType = whiteAuthType;
	}


	public void setBlackAuthType(ScrumchessAuthenticationType blackAuthType) {
		this.blackAuthType = blackAuthType;
	}

	public String getWhiteToken() {
		return whiteToken;
	}

	public String getBlackToken() {
		return blackToken;
	}

	public ScrumchessAuthenticationType getWhiteAuthType() {
		return whiteAuthType;
	}

	public ScrumchessAuthenticationType getBlackAuthType() {
		return blackAuthType;
	}

	public SimpleUserCredentials getWhiteCred() {
		return whiteCred;
	}

	public SimpleUserCredentials getBlackCred() {
		return blackCred;
	}
	
	
}
