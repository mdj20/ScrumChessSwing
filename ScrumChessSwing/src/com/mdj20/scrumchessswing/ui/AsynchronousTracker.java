package com.mdj20.scrumchessswing.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AsynchronousTracker<K>  {
	private boolean waiting;
	private HashMap<K, Meta> map = new HashMap<K, Meta>();
	private Queue<K> eventQueue = new LinkedList<K>();
	
	public boolean isWaiting() {
		return waiting;
	}
	
	public synchronized boolean setWaiting(boolean set) {
		boolean ret = set;
		this.waiting = set;
		return ret;
	}
	
	public synchronized void set(K event) {
		if( map.containsKey(event) ) {
			map.put(event, new Meta( System.currentTimeMillis()) );
			setWaiting(true);
		}
	}
	
	public synchronized boolean isTrackingEvent( K event ){
		boolean ret = false;
		if( map.containsKey(event) ) {
			map.get(event).nQuerries++;
		}
		return ret;
	}
	
	public synchronized int getNumberQueries(K event ) {
		int ret = -1;
		if(map.containsKey(event)) {
			ret = map.get(event).nQuerries;
		}
		return ret;
	}
	public synchronized boolean resolve(K event) {
		boolean ret = false;
		if( map.containsKey(event) ) {
			map.remove(event);
			eventQueue.remove(event);
			if(map.size()>0) {
				ret = true;
			}
		}
		return ret;
	}

	public synchronized long getLongestTimePast() {
		long ret = -1;
		if( map.size() > 0 ) {
			
		}
	}
	
	public synchronized void enqueueEvent(K event) {
		eventQueue.add(event);
	}
	
	class Meta {
		long start;
		int nQuerries;
		Meta( long start ){
			this.start = start;
			this.nQuerries = 0;
		}
	}
	
}
