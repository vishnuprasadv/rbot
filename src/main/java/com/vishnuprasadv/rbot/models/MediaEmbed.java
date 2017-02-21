package com.vishnuprasadv.rbot.models;

public class MediaEmbed {
	private String content;

	private Integer height;

	private Boolean scrolling;

	private Integer width;

	public String getContent() {
		return this.content;
	}

	public Integer getHeight() {
		return this.height;
	}

	public Boolean getScrolling() {
		return this.scrolling;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setScrolling(Boolean scrolling) {
		this.scrolling = scrolling;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}