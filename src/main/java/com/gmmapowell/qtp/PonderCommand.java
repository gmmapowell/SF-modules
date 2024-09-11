package com.gmmapowell.qtp;

import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class PonderCommand implements AtCommandHandler {

	private ConfiguredState state;

	public PonderCommand(ScannerAtState sas) {
		this.state = sas.state();
	}

	@Override
	public String name() {
		return "Ponder";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("Ponder command");
		String style = "ponder";
		state.newPara(style);
		state.processText("Questions to ponder:");
		state.endPara();
	}

}
