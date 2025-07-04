package com.gmmapowell.workloud;

import org.zinutils.exceptions.NotImplementedException;

import com.gmmapowell.script.config.ScriptConfig;
import com.gmmapowell.script.config.VarMap;
import com.gmmapowell.script.config.reader.ConfigListener;
import com.gmmapowell.script.config.reader.ReadConfigState;
import com.gmmapowell.script.elements.block.BlockishElementFactory;
import com.gmmapowell.script.modules.processors.doc.AmpCommandHandler;
import com.gmmapowell.script.modules.processors.doc.AmpSpotter;
import com.gmmapowell.script.modules.processors.doc.AtBlankSpotter;
import com.gmmapowell.script.modules.processors.doc.AtCommandHandler;
import com.gmmapowell.script.modules.processors.doc.AtSpotter;
import com.gmmapowell.script.modules.processors.doc.EndAtSpotter;
import com.gmmapowell.script.modules.processors.doc.FieldSpotter;
import com.gmmapowell.script.modules.processors.doc.GlobalState;
import com.gmmapowell.script.processor.configured.ConfiguredProcessor;
import com.gmmapowell.script.utils.Command;

public class WorkLoudConfigListener implements ConfigListener {
	private final ReadConfigState state;
	private final ScriptConfig config;
	private VarMap vars = new VarMap();

	public WorkLoudConfigListener(ReadConfigState state) {
		this.state = state;
		this.config = state.config;
	}

	@Override
	public ConfigListener dispatch(Command cmd) throws Exception {
		switch (cmd.name()) {
		case "separately": {
			vars.put(cmd.depth(), cmd.name(), "true");
			return null;
		}
		default: {
			throw new NotImplementedException("article processor does not have parameter " + cmd.name());
		}
		}
	}

	@Override
	public void complete() throws Exception {
		GlobalState global = state.config.newGlobalState();
		ConfiguredProcessor proc = new ConfiguredProcessor(global, state.root, new BlockishElementFactory(), vars, state.debug);
		proc.lifecycleObserver(new WatchFile());
		proc.setBlankHandler(WorkLoudLineProcessor.class);
		proc.setDefaultHandler(WorkLoudLineProcessor.class);
		proc.addScanner(AmpSpotter.class);
		proc.addScanner(AtSpotter.class);
		proc.addScanner(FieldSpotter.class);
		proc.addScanner(AtBlankSpotter.class);
		proc.addScanner(EndAtSpotter.class);
		state.config.processor(proc);

		installAtCommands();
		installAmpCommands();
//		installInlineCommands();
	}

	// @ commands
	private void installAtCommands() {
		this.config.extensions().bindExtensionPoint(AtCommandHandler.class, WorkLoudCommand.class);
	}
	
	// & commands
	private void installAmpCommands() {
		this.config.extensions().bindExtensionPoint(AmpCommandHandler.class, TotalHoursCommand.class);
		this.config.extensions().bindExtensionPoint(AmpCommandHandler.class, ProjectCommand.class);
		this.config.extensions().bindExtensionPoint(AmpCommandHandler.class, AchievedCommand.class);
		this.config.extensions().bindExtensionPoint(AmpCommandHandler.class, BlogCommand.class);
	}
}
