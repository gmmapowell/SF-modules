package com.gmmapowell.emailquoter;

import org.zinutils.exceptions.CantHappenException;

import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class QuoteEmailCommand implements AtCommandHandler {

	private ConfiguredState state;

	public QuoteEmailCommand(ScannerAtState sas) {
		this.state = sas.state();
	}

	@Override
	public String name() {
		return "QuoteEmail";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("QuoteEmail command");
		state.pushFormat("quoted-email");
	}


	@Override
	public void onEnd(AtCommand cmd) {
		state.popFormat("quoted-email");
	}

	@Override
	public boolean canContain(AtCommandHandler nested) {
//		return false;
		throw new CantHappenException("can't be asked to contain anything");
	}
}
