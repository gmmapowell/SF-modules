package com.gmmapowell.workloud;

import java.util.Set;
import java.util.TreeSet;

public class WOLGlobal {
	private int totalFiles = 0;
	private Set<String> allProjects = new TreeSet<>();

	public void countFile() {
		this.totalFiles++;
	}

	public void workedOn(String proj) {
		allProjects.add(proj);
	}

	public void summarize() {
		System.out.println("Summary:");
		System.out.println("  processed " + totalFiles + " files");
		System.out.println("  projects:");
		for (String s : allProjects) {
			System.out.println("    " + s);
		}
	}
}
