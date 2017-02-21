package com.vishnuprasadv.rbot.models;

public class SecureMedia {
	private Oembed oembed;

	private String type;

	public Oembed getOembed() {
		return this.oembed;
	}

	public String getType() {
		return this.type;
	}

	public void setOembed(Oembed oembed) {
		this.oembed = oembed;
	}

	public void setType(String type) {
		this.type = type;
	}
}