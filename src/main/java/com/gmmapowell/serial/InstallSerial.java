package com.gmmapowell.serial;

import org.zinutils.exceptions.CantHappenException;

import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.utils.Command;

public class InstallSerial implements ConfigListener {
	private final ReadConfigState state;

	public InstallSerial(ReadConfigState state) {
		this.state = state;
	}

	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		throw new CantHappenException("cannot configure serial module right now");
	}

	@Override
	public void complete() throws Exception {
		state.registerModule("serial", SerialConfigListener.class);
		state.config.extensions().bindExtensionPoint(AtCommandHandler.class, AtPoetryCommand.class);
	}
}
