package com.gmmapowell.nowmodule;

import org.zinutils.exceptions.CantHappenException;

import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.utils.Command;

public class InstallNowModule implements ConfigListener {
	private final ReadConfigState state;

	public InstallNowModule(ReadConfigState state) {
		this.state = state;
	}

	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		throw new CantHappenException("cannot configure serial module right now");
	}

	@Override
	public void complete() throws Exception {
		state.registerProcessor("now", NowConfigListener.class);
	}
}
