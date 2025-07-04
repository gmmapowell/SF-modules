package com.gmmapowell.workloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WOLState {
	private int totalFiles = 0;
	private String currentWOL;
	private boolean seenAtWOL;
	private Integer hours;
	private Set<String> allProjects = new TreeSet<>();
	private List<String> currProjects = new ArrayList<>();
	private List<String> achievements = new ArrayList<>();

	public void currentFile(String name) {
		this.currentWOL = name;
		this.totalFiles++;
		reset();
		System.out.println("wol name = " + name);
	}

	private void reset() {
		this.seenAtWOL = false;
		this.hours = null;
		this.currProjects.clear();
	}

	public void seenAtCmd() {
		if (this.seenAtWOL) {
			throw new RuntimeException("multiple @WorkOutLoud in same file");
		}
		this.seenAtWOL = true;
	}

	public void hoursThisWeek(int cnt) {
		if (this.hours != null) {
			throw new RuntimeException("multiple &totalhours in same file");
		}
		this.hours = cnt;
	}

	public void workedOn(String proj) {
		allProjects.add(proj);
		currProjects.add(proj);
	}

	public void haveAchieved(String proj) {
		achievements.add(proj);
	}

	public void summarizeFile() {
		if (!seenAtWOL) {
			throw new RuntimeException("no @WorkOutLoud for " + this.currentWOL);
		}
		if (hours == null) {
			throw new RuntimeException("no &totalhours for " + this.currentWOL);
		}
		System.out.println("for file " + this.currentWOL);
		System.out.println("  hours " + this.hours);
		for (String s : currProjects) {
			System.out.println("  project " + s);
		}
		for (String s : achievements) {
			System.out.println("  achieved " + s);
		}
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
