package com.gmmapowell.serial;

import com.gmmapowell.script.config.ConfigException;
import com.gmmapowell.script.config.ProcessorConfig;
import com.gmmapowell.script.config.reader.ModuleActivator;

public class SerialHandler implements ModuleActivator {

	@Override
	public void activate(ProcessorConfig proc) throws ConfigException {
		proc.addScanner(DashDashScanner.class);
	}

}
