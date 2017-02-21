package com.vishnuprasadv.rbot.online;

@FunctionalInterface
public interface OnlineStorageService {
	public void uploadImage(String filePath) throws Exception;
}
