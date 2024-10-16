package com.gmmapowell.serial;

public class PoetryState {
	private boolean inPoem = false;
	
	public void enable() {
		inPoem = true;
	}
	
	public void clear() {
		inPoem = false;
	}
	
	public boolean active() {
		return inPoem;
	}
}
