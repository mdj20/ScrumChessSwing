package com.mdj20.scrumchessswing;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/*
 * 
 */

public class ScrumchessEndPoint {

	URL url;
	String defaultPort = "8888";
	String defaultLocalHostString = "http://localhost:";
	
	
	
	private URL buildURL(String urlString) {
		URL ret = null;
		try {
			ret = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private static HttpURLConnection setupConnection(URL url ) {
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
	
	private static void writePostParamaters(HttpURLConnection conn, Map<String,String> params) {
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
	
	
}
