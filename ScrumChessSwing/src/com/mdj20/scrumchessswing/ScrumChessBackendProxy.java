package com.mdj20.scrumchessswing;

import com.scrumchess.userrequests.GameInfoRequest;
import com.scrumchess.userrequests.GameInfoResponse;
import com.scrumchess.userrequests.MoveRequest;
import com.scrumchess.userrequests.MoveRequestResponse;
import com.scrumchess.userrequests.NewGameRequest;
import com.scrumchess.userrequests.NewGameResponse;

public interface ScrumChessBackendProxy {
	public NewGameResponse tryNewGameRequest(NewGameRequest request);
	public GameInfoResponse tryNewGameRequest(GameInfoRequest request);
	public MoveRequestResponse tryMoveRequest(MoveRequest moveRequest);
}
