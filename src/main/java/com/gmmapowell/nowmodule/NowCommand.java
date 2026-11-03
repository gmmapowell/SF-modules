package com.gmmapowell.nowmodule;

import com.gmmapowell.script.flow.SaveAs;
import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class NowCommand implements AtCommandHandler {
	private ConfiguredState state;
	private String date;
	private String written;

	public NowCommand(ScannerAtState sas) {
		this.state = sas.state();
	}
	

	@Override
	public String name() {
		return "Now";
	}

	@Override
	public void invoke(AtCommand cmd) {
		date = cmd.arg("date");
		if (date == null)
			throw new RuntimeException("@Now without date");
		written = cmd.arg("written");

		String saveAs = "now/when-" + date;
		state.ensureFlow(saveAs);
		state.newSection(saveAs, "now");
		state.newPara();
		state.newSpan();
		state.op(new SaveAs(saveAs));
		state.endPara();
	}

	@Override
	public void onEnd(AtCommand cmd) {
		if (written != null) {
			System.out.println("\nhello");
		}
	}
}
