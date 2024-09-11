package com.gmmapowell.qtp;

import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class QuestionsToPonderCommand implements AtCommandHandler {
	private final ConfiguredState state;

	public QuestionsToPonderCommand(ScannerAtState state) {
		this.state = state.state();
	}

	@Override
	public String name() {
		return "QuestionsToPonder";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("QuestionsToPonder command");
		state.newSection("main", "chapter");
	}

}
