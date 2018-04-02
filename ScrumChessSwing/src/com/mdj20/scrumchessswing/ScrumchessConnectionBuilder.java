package com.mdj20.scrumchessswing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.gson.Gson;
import com.scrumchess.authentication.ScrumchessAuthenticationType;
import com.scrumchess.authentication.SimpleUserAuthenticationInfo;
import com.scrumchess.authentication.SimpleUserCredentials;
import com.scrumchess.userrequests.GameInfoRequest;
import com.scrumchess.userrequests.GameInfoResponse;
import com.scrumchess.userrequests.MoveRequest;
import com.scrumchess.userrequests.MoveRequestResponse;
import com.scrumchess.userrequests.NewGameRequest;
import com.scrumchess.userrequests.NewGameResponse;
import com.scrumchess.userrequests.ScrumChessGsonBuilder;


public class ScrumchessConnectionBuilder implements ScrumChessBackendProxy{
	public static final String defaultPort = "8080";
	public static final String defaultLocalHostString = "http://localhost:";
	private String port = defaultPort;
	private String hostString = defaultLocalHostString+port;
	
	ScrumchessConnectionBuilder(String hostString, int port){
		this.hostString = hostString;
		this.port = Integer.toString(port);	
	}
	
	ScrumchessConnectionBuilder(){};
	
	private URL buildURL(String urlString) throws MalformedURLException {
		URL ret = null;
			ret = new URL(urlString);
		return ret;
	}
	public HttpURLConnection buildScrumchessConnection(String appendedURL) {
		URL url = null;
		try {
			url = this.buildURL(this.hostString+appendedURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection conn = setupPostConnection(url);
		return conn;
	}
	
	private static HttpURLConnection setupPostConnection(URL url ) {
		HttpURLConnection ret = null;
		try {
			ret = (HttpURLConnection) url.openConnection();
			ret.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			ret.setRequestProperty( "charset", "utf-8");
			ret.setRequestMethod("POST");
			ret.setDoOutput(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void writePostParamaters(HttpURLConnection conn, Map<String,String> params) {
		StringBuilder sb = new StringBuilder();
		for(String s:params.keySet()) {
			sb.append(s).append("=").append(params.get(s)).append("&");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1); // chomp last
		}
		byte[] paramBytes = sb.toString().getBytes(StandardCharsets.UTF_8);
		int length = paramBytes.length;
		conn.setRequestProperty("Content-Length", Integer.toString(length));
		try {
			conn.getOutputStream().write(paramBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//smoketest
	public static void main(String args[]) {
		SimpleUserAuthenticationInfo<String> userInfo = new SimpleUserAuthenticationInfo<String>(new SimpleUserCredentials(ScrumchessAuthenticationType.DEBUG,"User1"));
		NewGameRequest ngrequest = new NewGameRequest(userInfo,NewGameRequest.NewGameConfig.WHITE);
		ScrumchessConnectionBuilder scb = new ScrumchessConnectionBuilder();
		HttpURLConnection conn = scb.buildScrumchessConnection("/newgamegson");
		Gson gson = new Gson();
		String json = gson.toJson(ngrequest);
		byte[] bytes = json.getBytes();
		int length = bytes.length;
		conn.setRequestProperty("Content-Length", Integer.toString(length));
		BufferedReader br;
		try {
			conn.getOutputStream().write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String response = null;
		try {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			response = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(response);
		NewGameResponse ngresponse = gson.fromJson(response, NewGameResponse.class);
		System.out.println(ngresponse.isSuccessful());
		System.out.println(ngresponse.getResponseObject().getId());
		
		
		NewGameResponse res = scb.tryNewGameRequest(ngrequest);
		System.out.println(res.isSuccessful()+"\n"+res.getResponseObject().getFen());
		long gameID = res.getResponseObject().getId();
		
		MoveRequest move = new MoveRequest(userInfo,gameID,"e2e4");
		
		MoveRequestResponse moveres = scb.tryMoveRequest(move);
		
		GameInfoRequest infoRequest = new GameInfoRequest(userInfo,gameID);
		
		GameInfoResponse gires = scb.tryGameInfoRequest(infoRequest);
		System.out.println(gires.isSuccessful()+"\n"+res.getResponseObject().getFen());
		
	}
	
	private BufferedReader sendJson(HttpURLConnection conn, String json){
		BufferedReader br=null;
		byte[] bytes = json.getBytes();
		int length = bytes.length;
		conn.setRequestProperty("Content-Length", Integer.toString(length));

		try {
			conn.getOutputStream().write(bytes);
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return br;
	}
	
	private <T> T constructObject(BufferedReader reader, Class<T> clazz){
		T ret = null;
		Gson gson = ScrumChessGsonBuilder.getSCGson();
		String json = null;
		try {
			json = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(json!=null){
			ret = gson.fromJson(json, clazz);
		}
		return ret;
	}
	
	
	@Override
	public NewGameResponse tryNewGameRequest(NewGameRequest request) {
		HttpURLConnection conn = buildScrumchessConnection("/newgamegson");
		NewGameResponse response= null;
		Gson gson = new Gson();
		String json = gson.toJson(request);
		if(conn!=null){
			BufferedReader br = sendJson(conn,json);
			response = constructObject(br,NewGameResponse.class);
		}
		return response;
	}
	

	@Override
	public MoveRequestResponse tryMoveRequest(MoveRequest moveRequest) {
		HttpURLConnection conn = buildScrumchessConnection("/movegson");
		MoveRequestResponse response= null;
		Gson gson = new Gson();
		String json = gson.toJson(moveRequest);
		if(conn!=null){
			BufferedReader br = sendJson(conn,json);
			response = constructObject(br,MoveRequestResponse.class);
		}
		return response;
	}

	@Override
	public GameInfoResponse tryGameInfoRequest(GameInfoRequest request) {
		HttpURLConnection conn = buildScrumchessConnection("/gameinfogson");
		GameInfoResponse response = null;
		Gson gson = new Gson();
		String json = gson.toJson(request);
		if(conn!=null){
			BufferedReader br = sendJson(conn,json);
			response = constructObject(br,GameInfoResponse.class);
		}
		return response;
	}
	
	
	
	
	
	
}
