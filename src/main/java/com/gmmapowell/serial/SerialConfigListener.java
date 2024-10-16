package com.gmmapowell.serial;

import org.zinutils.exceptions.CantHappenException;

import com.gmmapowell.script.config.ConfigException;
import com.gmmapowell.script.config.ProcessorConfig;
import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ModuleConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.utils.Command;

public class SerialConfigListener implements ModuleConfigListener {
	private SerialHandler handler;

	public SerialConfigListener(ReadConfigState state) {
	}
	
	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		throw new CantHappenException("no config");
	}

	@Override
	public void complete() throws Exception {
		this.handler = new SerialHandler();
	}

	@Override
	public void activate(ProcessorConfig proc) throws ConfigException {
		proc.addScanner(PoetryFormatter.class);
		this.handler.activate(proc);
	}

}
