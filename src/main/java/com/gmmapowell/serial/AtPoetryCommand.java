package com.gmmapowell.serial;

import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class AtPoetryCommand implements AtCommandHandler {
	private final ConfiguredState sink;
	private final PoetryState poem;

	public AtPoetryCommand(ScannerAtState sas) {
		this.sink = sas.state();
		poem = sink.require(PoetryState.class);
	}

	@Override
	public String name() {
		return "Poetry";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("is-poem");
		poem.enable();
		sink.pushFormat("poetry");
	}
	
	@Override
	public void onEnd(AtCommand cmd) {
		sink.popFormat("poetry");
		poem.clear();
	}

}
