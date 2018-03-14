package com.mdj20.scrumchessswing;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.scrumchess.userrequests.NewGameRequest;

public class Endpoint implements Runnable {

	LinkedBlockingQueue<Move> userMoves;
	private boolean running;
	
	
	Endpoint(){
		userMoves = new LinkedBlockingQueue<Move>();
	}
	
	@Override
	public void run() {
		System.out.println("Endpoint running!!!!");
		setRunning(true);
		while(running){ // run loop
			if(! this.pollOutgoingMove()){ // thread sleep if queue is empty
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sendMove(Move move){
		userMoves.add(move);
	}
	
	private boolean pollOutgoingMove(){
		System.out.println("Polling");
		boolean ret = false;
		// for now I'm just going to printinfo
		Move move = this.userMoves.poll();
		if ( move != null){
			System.out.println("Got move!");
			processMove(move);
			ret = true;
		}
		return ret;
	}

	private void processMove(Move move){
		System.out.println("User "+move.user);
		//System.out.println("from "+move.from.getRank()+" "+move.from.getFile());
		//System.out.println("to "+move.to.getRank()+" "+move.to.getFile());
	}
	
	public synchronized void setRunning(boolean value){
		this.running = value;
	}
	
	public static void main(String args[]) throws InterruptedException{
		Endpoint endpoints = new Endpoint();
		new Thread(endpoints).start();
		for(int i =0;i<25;i++){
			endpoints.sendMove(new Move(new StringBuilder().append("USER").append(Integer.toString(i)).toString()));
			
			
		}
		Thread.sleep(2000);
		endpoints = new Endpoint();
		new Thread(endpoints).start();
		for(int i =0;i<25;i++){
			endpoints.sendMove(new Move(new StringBuilder().append("USER").append(Integer.toString(i)).toString()));
		}
		
		System.out.println("Killing");
		endpoints.setRunning(false);
	}
	
	
	
}
