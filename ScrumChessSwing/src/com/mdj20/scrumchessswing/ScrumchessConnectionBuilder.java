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


/*
 * 
 */

public class ScrumchessConnectionBuilder implements ScrumChessBackendProxy{
	public static final String defaultPort = "8080";
	public static final String defaultLocalHostString = "http://localhost:";
	private String port = defaultPort;
	private String hostString = defaultLocalHostString+port;
	
	ScrumchessConnectionBuilder(String hostString){
		this.hostString = hostString;
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
	}

	@Override
	public NewGameResponse tryNewGameRequest(NewGameRequest request) {
		HttpURLConnection conn = buildScrumchessConnection("/newgamegson");
		return null;
	}

	@Override
	public GameInfoResponse tryNewGameRequest(GameInfoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoveRequestResponse tryMoveRequest(MoveRequest moveRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
