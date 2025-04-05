package com.gmmapowell.serial;

import com.gmmapowell.script.flow.NonBreakingSpace;
import com.gmmapowell.script.processor.configured.ConfiguredState;
import com.gmmapowell.script.processor.configured.ProcessingScanner;

public class PoetryFormatter implements ProcessingScanner {
	private final ConfiguredState state;
	private final PoetryState poem;

	public PoetryFormatter(ConfiguredState state) {
		this.state = state;
		poem = state.require(PoetryState.class);
	}
	
	@Override
	public boolean handleLine(String s) {
		// allow commands to go ahead ...
		if (s.startsWith("@") || s.startsWith("&"))
			return false;
		
		if (poem.active()) {
			state.newPara();
			state.newSpan();
			int i=0;
			for (i=0;i<4;i++) {
				state.op(new NonBreakingSpace());
			}
			state.processText(s);
			state.endPara();
			return true; // we processed the line
		} else {
			return false;
		}
	}
}
