package com.gmmapowell.serial;

public class PoetryState {
	private boolean inPoem = false;
	private boolean seenBlank = true;
	
	public void enable() {
		inPoem = true;
	}
	
	public void clear() {
		inPoem = false;
	}
	
	public boolean active() {
		return inPoem;
	}
	
	public boolean seenBlank() {
		boolean ret = seenBlank;
		seenBlank = true;
		return ret;
	}
	
	public void seenNonBlank() {
		seenBlank = false;
	}
}
