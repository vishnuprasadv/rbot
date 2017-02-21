package com.vishnuprasadv.rbot.models;

import java.util.ArrayList;

public class Data {
	private String after;

	private Object before;

	private ArrayList<Child> children;

	private String modhash;

	public String getAfter() {
		return this.after;
	}

	public Object getBefore() {
		return this.before;
	}

	public ArrayList<Child> getChildren() {
		return this.children;
	}

	public String getModhash() {
		return this.modhash;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public void setBefore(Object before) {
		this.before = before;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}

	public void setModhash(String modhash) {
		this.modhash = modhash;
	}
}