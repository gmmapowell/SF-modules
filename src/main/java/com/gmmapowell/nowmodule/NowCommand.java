package com.gmmapowell.nowmodule;

import com.gmmapowell.script.flow.SaveAs;
import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class NowCommand implements AtCommandHandler {
	private ConfiguredState state;

	public NowCommand(ScannerAtState sas) {
		this.state = sas.state();
	}
	

	@Override
	public String name() {
		return "Now";
	}

	@Override
	public void invoke(AtCommand cmd) {
		String date = cmd.arg("date");
		if (date == null)
			throw new RuntimeException("@Now without date");

		String saveAs = "now/when-" + date;
		state.ensureFlow(saveAs);
		state.newSection(saveAs, "now");
		state.newPara();
		state.newSpan();
		state.op(new SaveAs(saveAs));
		state.endPara();
	}

}
