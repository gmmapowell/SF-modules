package com.gmmapowell.workloud;

import com.gmmapowell.script.processor.configured.ConfiguredState;
import com.gmmapowell.script.processor.configured.ProcessingHandler;

public class WorkLoudLineProcessor implements ProcessingHandler {
	private ConfiguredState state;

	public WorkLoudLineProcessor(ConfiguredState state) {
		this.state = state;
	}

	@Override
	public void process(String s) {
		WOLState wols = state.require(WOLState.class);
		wols.randomContent(s);
//		System.out.println("need to handle " + s);
	}
}
