package com.vishnuprasadv.rbot.online.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.vishnuprasadv.rbot.online.OnlineStorageService;

@Service(value = "dropBoxImpl")
public class DropBoxStorage implements OnlineStorageService {

	@Value("${dropbox.access.token}")
	private String accessToken;

	private boolean isReady;

	private DbxRequestConfig dbxRequestConfig;

	private DbxClientV2 dbxClient;

	public DropBoxStorage() {
		this.isReady = false;
	}

	private void instantiate() {
		this.dbxRequestConfig = new DbxRequestConfig("myrbottest");
		this.dbxClient = new DbxClientV2(this.dbxRequestConfig, this.accessToken);
		this.isReady = true;
	}

	@Override
	public void uploadImage(String filePath) throws Exception {
		if (!isReady) {
			this.instantiate();
		}
		File file = new File(filePath);
		InputStream stream = new FileInputStream(filePath);
		this.dbxClient.files().uploadBuilder("/" + file.getName()).uploadAndFinish(stream);
	}

}
