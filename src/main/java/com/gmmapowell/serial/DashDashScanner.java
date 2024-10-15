package com.gmmapowell.serial;

import com.gmmapowell.script.processor.configured.ConfiguredState;
import com.gmmapowell.script.processor.configured.ProcessingScanner;

public class DashDashScanner implements ProcessingScanner {
	private final ConfiguredState state;

	public DashDashScanner(ConfiguredState state) {
		this.state = state;
	}

	@Override
	public boolean handleLine(String s) {
		if ("--".equals(s)) {
			state.newPara();
			state.newSpan();
			state.op(new SectionBreak());
			state.endPara();
			return true;
		}
		return false;
	}

}
