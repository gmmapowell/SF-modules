package com.gmmapowell.workloud;

import java.util.ArrayList;
import java.util.List;

import com.gmmapowell.script.flow.NonBreakingSpace;
import com.gmmapowell.script.processor.configured.ConfiguredState;

public class WOLState {
	private WOLGlobal global;
	private String wolName;
	private boolean seenAtWOL;
	private Float hours;
	private List<String> currProjects = new ArrayList<>();
	private List<String> achievements = new ArrayList<>();
	private List<String> topics = new ArrayList<>();

	public WOLState() {
	}
	
	public void currentFile(ConfiguredState state, WOLGlobal global, String name) {
		this.global = global;
		this.wolName = name;
		global.countFile(state);
		reset();
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

	public void hoursThisWeek(float hrs) {
		if (!seenAtWOL) {
			throw new RuntimeException("cannot have content before @WorkOutLoud");
		}
		if (this.hours != null) {
			throw new RuntimeException("multiple &totalhours in same file");
		}
		this.hours = hrs;
		global.hours(hrs);
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
			throw new RuntimeException("no @WorkOutLoud for " + this.wolName);
		}
		if (hours == null) {
			throw new RuntimeException("no &totalhours for " + this.wolName);
		}
		System.out.println("for file " + this.wolName);
		System.out.println("  hours " + this.hours);
		for (String s : currProjects) {
			System.out.println("  worked on " + s);
		}
		for (String s : achievements) {
			System.out.println("  achieved " + s);
		}
		for (String s : topics) {
			System.out.println("  blogged about " + s);
		}
	}

	public void outputHTML(ConfiguredState state) {
		state.newSection("wol", "work-out-loud");
		state.newPara("as-div");
		state.newSpan("div-workoutloud", "div-title");
		global.ensureSaveAs(state, "workoutloud");
		state.text(wolName);
		state.newSpan("div-workoutloud", "div-hours");
		state.text(this.hours + " hours");
		for (String s : currProjects) {
			state.newSpan("div-workoutloud", "div-worked-on");
			state.text(s);
			state.newSpan("div-workoutloud");
			state.op(new NonBreakingSpace());
		}
		for (String s : achievements) {
			state.newSpan("div-workoutloud", "div-achieved");
			state.text(s);
			state.newSpan("div-workoutloud");
			state.op(new NonBreakingSpace());
		}
		for (String s : topics) {
			state.newSpan("div-workoutloud", "div-blogged-about");
			state.text(s);
			state.newSpan("div-workoutloud");
			state.op(new NonBreakingSpace());
		}
	}
}
