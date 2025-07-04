package com.gmmapowell.workloud;

import com.gmmapowell.script.modules.processors.doc.AmpCommand;
import com.gmmapowell.script.modules.processors.doc.AmpCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAmpState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class TotalHoursCommand implements AmpCommandHandler{
	private ConfiguredState state;

	public TotalHoursCommand(ScannerAmpState state) {
		this.state = state.state();
	}
	
	@Override
	public String name() {
		return "totalhours";
	}

	@Override
	public void invoke(AmpCommand cmd) {
		WOLState wols = state.require(WOLState.class);
		String arg = cmd.args.readArg();
		Float f = Float.parseFloat(arg);
		cmd.args.argsDone();
		System.out.println("arg = " + arg);
		wols.hoursThisWeek(f);
	}
}
