package com.vishnuprasadv.rbot.source;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageSourceBuilder {

	@Value("${imageSources.list}")
	private String subredditList;

	private List<ImageSource> imageSources = null;

	public ImageSourceBuilder() {
		this.imageSources = new ArrayList<>();
	}

	/**
	 * @return the imageSources
	 */
	public List<ImageSource> getImageSources() {
		return imageSources;
	}

	/**
	 * @param imageSources
	 *            the imageSources to set
	 */
	public void setImageSources(List<ImageSource> imageSources) {
		this.imageSources = imageSources;
	}

	public void buildImageSourcesList() {
		for (String source : subredditList.split(";")) {
			this.imageSources.add(new ImageSource(source));
		}
	}
}
