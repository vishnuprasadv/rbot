package com.vishnuprasadv.rbot.source;

public class ImageSource {

	private String subreddit;

	/**
	 * ImageSource default constructor
	 */
	public ImageSource() {
		this.subreddit = "EarthPorn";
	}

	public ImageSource(String subreddit) {
		this.subreddit = subreddit;
	}

	/**
	 * @return the subreddit
	 */
	public String getSubreddit() {
		return subreddit;
	}

}
