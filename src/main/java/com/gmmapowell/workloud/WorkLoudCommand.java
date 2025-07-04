package com.gmmapowell.workloud;

import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class WorkLoudCommand implements AtCommandHandler {
	private ConfiguredState state;

	public WorkLoudCommand(ScannerAtState sas) {
		this.state = sas.state();
	}
	

	@Override
	public String name() {
		return "WorkOutLoud";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("@workoutloud");
		WOLState wols = state.require(WOLState.class);
		wols.seenAtCmd();
	}

}
