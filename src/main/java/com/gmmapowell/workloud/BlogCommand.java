package com.gmmapowell.workloud;

import com.gmmapowell.script.modules.processors.doc.AmpCommand;
import com.gmmapowell.script.modules.processors.doc.AmpCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAmpState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class BlogCommand implements AmpCommandHandler{
	private ConfiguredState state;

	public BlogCommand(ScannerAmpState state) {
		this.state = state.state();
	}
	
	@Override
	public String name() {
		return "blog";
	}

	@Override
	public void invoke(AmpCommand cmd) {
		System.out.println("blog");
		WOLState wols = state.require(WOLState.class);
		wols.bloggedAbout("a topic");
	}
}
