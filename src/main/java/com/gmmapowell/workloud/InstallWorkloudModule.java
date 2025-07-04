package com.gmmapowell.workloud;

import org.zinutils.exceptions.CantHappenException;

import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.utils.Command;

public class InstallWorkloudModule implements ConfigListener {
	private final ReadConfigState state;

	public InstallWorkloudModule(ReadConfigState state) {
		this.state = state;
	}

	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		throw new CantHappenException("cannot configure serial module right now");
	}

	@Override
	public void complete() throws Exception {
		state.registerProcessor("workoutloud", WorkLoudConfigListener.class);
	}
}
