package com.vishnuprasadv.rbot.models;

import java.util.ArrayList;

public class Image {
	private String id;

	private ArrayList<Resolution> resolutions;

	private Source source;

	private Variants variants;

	public String getId() {
		return this.id;
	}

	public ArrayList<Resolution> getResolutions() {
		return this.resolutions;
	}

	public Source getSource() {
		return this.source;
	}

	public Variants getVariants() {
		return this.variants;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setResolutions(ArrayList<Resolution> resolutions) {
		this.resolutions = resolutions;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public void setVariants(Variants variants) {
		this.variants = variants;
	}
}