package com.mdj20.scrumchessswing.ajaxswingworkers;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.mdj20.scrumchessswing.Endpoint;
import com.mdj20.scrumchessswing.Game;
import com.mdj20.scrumchessswing.Move;

public class MoveSender extends SwingWorker<Game, Move> {
	private Move move; // url
	private URL url; // url
	MoveSender(Move move){
		this.move = move;
	}

	@Override
	protected Game doInBackground() {
		Gson gson = new Gson();
		String moveJson = gson.toJson(move);	
		try {
			url = new URL(ScrumchessLocalInfo.baseURL+ScrumchessLocalInfo.moveAcceptionSuffix);
		} catch (MalformedURLException e) {
			// this will catch the hardware errors
			e.printStackTrace();
		}		
		return null;
	}
}
