package com.vishnuprasadv.rbot.models;

class Media {
	private Oembed2 oembed;

	private String type;

	public Oembed2 getOembed() {
		return this.oembed;
	}

	public String getType() {
		return this.type;
	}

	public void setOembed(Oembed2 oembed) {
		this.oembed = oembed;
	}

	public void setType(String type) {
		this.type = type;
	}
}

public class Model {
	private Data data;

	private String kind;

	public Data getData() {
		return this.data;
	}

	public String getKind() {
		return this.kind;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	}

class Oembed2 {
	private String description;

	private int height;

	private String html;

	private String provider_name;

	private String provider_url;

	private int thumbnail_height;

	private String thumbnail_url;

	private int thumbnail_width;

	private String title;

	private String type;

	private String version;

	private int width;

	public String getDescription() {
		return this.description;
	}

	public int getHeight() {
		return this.height;
	}

	public String getHtml() {
		return this.html;
	}

	public String getProviderName() {
		return this.provider_name;
	}

	public String getProviderUrl() {
		return this.provider_url;
	}

	public int getThumbnailHeight() {
		return this.thumbnail_height;
	}

	public String getThumbnailUrl() {
		return this.thumbnail_url;
	}

	public int getThumbnailWidth() {
		return this.thumbnail_width;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getVersion() {
		return this.version;
	}

	public int getWidth() {
		return this.width;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setProviderName(String provider_name) {
		this.provider_name = provider_name;
	}

	public void setProviderUrl(String provider_url) {
		this.provider_url = provider_url;
	}

	public void setThumbnailHeight(int thumbnail_height) {
		this.thumbnail_height = thumbnail_height;
	}

	public void setThumbnailUrl(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public void setThumbnailWidth(int thumbnail_width) {
		this.thumbnail_width = thumbnail_width;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}

class Resolution {
	private int height;

	private String url;

	private int width;

	public int getHeight() {
		return this.height;
	}

	public String getUrl() {
		return this.url;
	}

	public int getWidth() {
		return this.width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}

class SecureMediaEmbed {
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

class Variants {
}