package com.mdj20.scrumchessswing;

public class SmokeTest implements Runnable {
	
	private Endpoint endpoint;
	boolean running = false;
	
	SmokeTest(Endpoint epoint){
		this.endpoint = epoint;
	}

	@Override
	public void run() {
		running = true;
		while(running){
			endpoint.sendMove(new Move("User"));
		}
	}

	public synchronized void setRunning(boolean value){
		this.running = value;
	}
}
