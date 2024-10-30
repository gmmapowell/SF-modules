package com.gmmapowell.qtp;

import org.zinutils.exceptions.CantHappenException;

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

	@Override
	public boolean canContain(AtCommandHandler nested) {
//		return false;
		throw new CantHappenException("can't be asked to contain anything");
	}
}
