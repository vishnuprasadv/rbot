package com.vishnuprasadv.rbot.services;

import java.io.IOException;
import java.io.InputStream;

public interface ImageService {
	public InputStream fetchImage(String url) throws IOException;
}
