package com.mdj20.scrumchessswing.ui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* Singleton class */

public class ScrumchessSwingLogger {
	private volatile static ScrumchessSwingLogger logger = null;
	private String fileName = "scslog.txt";
	private PrintWriter pw;
	
	ScrumchessSwingLogger(){
		try {
			pw = new PrintWriter(fileName,"UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger = this;
	}
	
	
	// get instance double check locked, logger is declared volatile
	public  ScrumchessSwingLogger getInstance(){
		if (logger == null){
			synchronized (ScrumchessSwingLogger.class) {
				if(logger == null){
					logger = new ScrumchessSwingLogger();
				}
			}
		}
		return logger;
	}
	
	public synchronized void println(String statement){
		pw.println(statement);
	}
	
	public void closeAndUninitialize(){
		synchronized (ScrumchessSwingLogger.class) {
			pw.close();
			logger = null;
		}
	}
}
