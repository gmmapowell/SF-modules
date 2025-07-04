package com.gmmapowell.workloud;

import com.gmmapowell.script.modules.processors.doc.AmpCommand;
import com.gmmapowell.script.modules.processors.doc.AmpCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAmpState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class AchievedCommand implements AmpCommandHandler{
	private ConfiguredState state;

	public AchievedCommand(ScannerAmpState state) {
		this.state = state.state();
	}
	
	@Override
	public String name() {
		return "achieved";
	}

	@Override
	public void invoke(AmpCommand cmd) {
		String arg = cmd.args.readArg();
		cmd.args.argsDone();
		WOLState wols = state.require(WOLState.class);
		wols.haveAchieved(arg);
	}
}
