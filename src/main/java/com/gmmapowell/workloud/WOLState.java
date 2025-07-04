package com.gmmapowell.workloud;

import java.util.ArrayList;
import java.util.List;

public class WOLState {
	private WOLGlobal global;
	private String currentWOL;
	private boolean seenAtWOL;
	private Integer hours;
	private List<String> currProjects = new ArrayList<>();
	private List<String> achievements = new ArrayList<>();
	private List<String> topics = new ArrayList<>();

	public WOLState() {
		System.out.println("wolstate");
	}
	
	public void currentFile(WOLGlobal global, String name) {
		this.global = global;
		this.currentWOL = name;
		global.countFile();
		reset();
		System.out.println("wol name = " + name);
	}

	private void reset() {
		this.seenAtWOL = false;
		this.hours = null;
		this.currProjects.clear();
		this.achievements.clear();
		this.topics.clear();
	}

	public void randomContent(String s) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
	}

	public void seenAtCmd() {
		if (this.seenAtWOL) {
			throw new RuntimeException("multiple @WorkOutLoud in same file");
		}
		this.seenAtWOL = true;
	}

	public void hoursThisWeek(int cnt) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
		if (this.hours != null) {
			throw new RuntimeException("multiple &totalhours in same file");
		}
		this.hours = cnt;
	}

	public void workedOn(String proj) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
		global.workedOn(proj);
		currProjects.add(proj);
	}

	public void haveAchieved(String proj) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
		achievements.add(proj);
	}

	public void bloggedAbout(String topic) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
		topics.add(topic);
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
		for (String s : topics) {
			System.out.println("  blogged about " + s);
		}
	}
}
