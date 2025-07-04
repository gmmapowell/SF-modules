package com.gmmapowell.workloud;

import com.gmmapowell.geofs.Place;
import com.gmmapowell.script.processor.configured.ConfiguredState;
import com.gmmapowell.script.processor.configured.LifecycleObserver;

public class WatchFile implements LifecycleObserver{
	private WOLGlobal global;

	@Override
	public void newPlace(ConfiguredState state, Place x) {
		global = state.global().requireState(WOLGlobal.class);
		WOLState wols = state.require(WOLState.class);
		String name = x.name().replace(".txt", "");
		wols.currentFile(state, global, name);
	}
	
	@Override
	public void placeDone(ConfiguredState state) {
		WOLState wols = state.require(WOLState.class);
		wols.summarizeFile();
		wols.outputHTML(state);
	}
	
	@Override
	public void processingDone() {
		global.summarize();
	}
}
