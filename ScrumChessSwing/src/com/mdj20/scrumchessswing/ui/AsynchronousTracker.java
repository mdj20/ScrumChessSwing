package com.mdj20.scrumchessswing.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class AsynchronousTracker<K>  {
	private boolean waiting;
	private HashMap<K,Meta> map = new HashMap<K,Meta>();
		
	public boolean isWaiting() {
		return waiting;
	}
	
	public synchronized boolean setWaiting(boolean set) {
		boolean ret = set;
		this.waiting = set;
		return ret;
	}
	
	public synchronized void set(K event) {
		map.put(event, new Meta(System.currentTimeMillis()));
		setWaiting(true);
	}
	
	public synchronized boolean resolve(K event) {
		boolean ret = false;
		if( map.containsKey(event) ) {
			map.remove(event);
			if(map.size()>0) {
				ret = true;
			}
		}
		return ret;
	}

	public synchronized long getLongestTimePast() {
		long ret = -1;
		if(map.size()>0) {
			;
		}
	}
	
	
	class Meta {
		long start;
		int nQuerries;
		Meta(long start){
			this.start = start;
			this.nQuerries = 0;
		}
	}
	
}
