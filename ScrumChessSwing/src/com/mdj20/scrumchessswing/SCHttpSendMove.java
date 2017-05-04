package com.mdj20.scrumchessswing;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class SCHttpSendMove {
	
	private final String urlString = "http://localhost:8888/movetest";
	URL url ;// temporary;
	
	SCHttpSendMove() throws MalformedURLException{
		url = new URL(urlString);		
	}

	public void openConnectionAndSend(InnerMove move) throws IOException{
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		OutputStream output = conn.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(output);
		Gson gson = new Gson();
		String obj = gson.toJson(move);
		//System.out.println(obj);
		osw.write(obj);
		osw.flush();
	}
	
	public static void main(String args[]){
		try {
			smokeTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private static void smokeTest() throws IOException{
		SCHttpSendMove sm = new SCHttpSendMove();
		InnerMove move = sm.getInnerMove();
		move.user = "User";
		move.from = "01";
		move.to = "25";
		sm.openConnectionAndSend(move);
	}
	
	public InnerMove getInnerMove(){
		return new InnerMove();
	}
	
	 class InnerMove{
		String user;
		String from;
		String to;
	}
	
}
