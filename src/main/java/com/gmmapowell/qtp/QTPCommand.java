package com.gmmapowell.qtp;

import com.gmmapowell.script.flow.NonBreakingSpace;
import com.gmmapowell.script.intf.KeepTogether;
import com.gmmapowell.script.intf.ReleaseTogether;
import com.gmmapowell.script.modules.processors.doc.AtCommand;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.ScannerAtState;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class QTPCommand implements AtCommandHandler {
	private ConfiguredState state;

	public QTPCommand(ScannerAtState sas) {
		this.state = sas.state();
	}

	@Override
	public String name() {
		return "QTP";
	}

	@Override
	public void invoke(AtCommand cmd) {
		System.out.println("QTP command");
		String title = cmd.arg("title");
		if (title == null)
			throw new RuntimeException("Chapter without title");
		String style = "qtp";
		state.newPara(style);
		state.newSpan("qtp-head");
		state.op(new KeepTogether());
		state.processTextInSpan(title);
		state.endSpan();
		state.newSpan();
		state.op(new NonBreakingSpace());
		state.op(new NonBreakingSpace());
		state.endSpan();
	}

	@Override
	public void onEnd(AtCommand cmd) {
		state.ensurePara();
		state.op(new ReleaseTogether());
	}
}
