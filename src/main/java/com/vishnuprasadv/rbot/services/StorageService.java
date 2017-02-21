package com.vishnuprasadv.rbot.services;

import java.io.InputStream;

@FunctionalInterface
public interface StorageService {
	public void persistImage(InputStream stream, String title);
}
