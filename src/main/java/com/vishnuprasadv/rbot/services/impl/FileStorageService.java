package com.vishnuprasadv.rbot.services.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vishnuprasadv.rbot.services.StorageService;

@Service
public class FileStorageService implements StorageService {

	@Value("${storage.path}")
	private String storagePath;

	private static Logger log = LoggerFactory.getLogger(FileStorageService.class);

	private String createFileName(String name) {
		return name + UUID.randomUUID().toString().substring(0, 5) + ".jpg";
	}

	@Override
	public void persistImage(InputStream stream, String title) {
		String fileName = this.createFileName(title);
		byte[] data = new byte[4096];
		int length;
		try (OutputStream output = new FileOutputStream(storagePath + fileName)) {
			while ((length = stream.read(data)) != -1) {
				output.write(data, 0, length);
			}
		} catch (IOException e) {
			log.error("Error saving the file", e);
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				log.error("Error saving the file", e);
			}
		}
	}

}
