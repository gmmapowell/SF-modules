package com.gmmapowell.emailquoter;

import com.gmmapowell.script.config.ConfigException;
import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.utils.Command;

public class InstallEmailQuoterModule implements ConfigListener {
	private final ReadConfigState state;

	public InstallEmailQuoterModule(ReadConfigState state) {
		this.state = state;
	}

	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		throw new ConfigException("InstallDocModule cannot be configured right now");
	}

	@Override
	public void complete() throws Exception {
		state.registerModule("emailquoter", EmailQuoterConfigListener.class);
	}
}
