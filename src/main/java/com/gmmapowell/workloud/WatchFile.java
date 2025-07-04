package com.gmmapowell.workloud;

import com.gmmapowell.geofs.Place;
import com.gmmapowell.script.processor.configured.ConfiguredState;
import com.gmmapowell.script.processor.configured.LifecycleObserver;

public class WatchFile implements LifecycleObserver{
	private ConfiguredState state;

	@Override
	public void newPlace(ConfiguredState state, Place x) {
		this.state = state;
		WOLState wols = state.require(WOLState.class);
		String name = x.name().replace(".txt", "");
		System.out.println("have " + name);
		wols.currentFile(name);
	}
	
	@Override
	public void placeDone(ConfiguredState state) {
		WOLState wols = state.require(WOLState.class);
		wols.summarizeFile();
	}
	
	@Override
	public void processingDone() {
		WOLState wols = state.require(WOLState.class);
		wols.summarize();
	}
}
