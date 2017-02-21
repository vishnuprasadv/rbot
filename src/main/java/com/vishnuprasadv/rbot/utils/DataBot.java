package com.vishnuprasadv.rbot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DataBot {

	@Value("${redditBot.UrlPrefix}")
	private String urlPrefix;

	@Value("${redditBot.userAgent}")
	private String userAgent;

	public DataBot() {
		this.urlPrefix = "https://www.reddit.com/r/";
	}

	public DataBot(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String retrieveData(String urlSuffix) throws IOException {
		StringBuilder jsonData = new StringBuilder();
		URL url = new URL(urlPrefix + urlSuffix);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("User-Agent", this.userAgent);
		if (connection.getResponseCode() != 200) {
			throw new IOException("Response doesn't indicate success. Received code : " + connection.getResponseCode());
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String str;
		while ((str = reader.readLine()) != null) {
			jsonData.append(str);
		}
		return jsonData.toString();

	}

	public InputStream retrieveStream(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("User-Agent", this.userAgent);
		if (connection.getResponseCode() != 200) {
			throw new IOException("Response doesn't indicate success. Received code : " + connection.getResponseCode());
		}
		return connection.getInputStream();
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
}