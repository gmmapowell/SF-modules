package com.gmmapowell.workloud;

import java.util.Set;
import java.util.TreeSet;

import com.gmmapowell.script.flow.SaveAs;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class WOLGlobal {
	private int totalFiles = 0;
	private float totalHours = 0;
	private Set<String> allProjects = new TreeSet<>();

	public void countFile(ConfiguredState state) {
		if (totalFiles == 0) {
			state.ensureFlow("wol");
		}
		this.totalFiles++;
	}

	public void ensureSaveAs(ConfiguredState state, String saveAs) {
		state.op(new SaveAs(saveAs));
	}

	public void hours(float f) {
		this.totalHours+=f;
	}

	public void workedOn(String proj) {
		allProjects.add(proj);
	}

	public void summarize() {
		System.out.println("Summary:");
		System.out.println("  processed " + totalFiles + " files");
		System.out.println("  hours " + (totalHours/totalFiles) + " per week");
		System.out.println("  projects:");
		for (String s : allProjects) {
			System.out.println("    " + s);
		}
	}
}
