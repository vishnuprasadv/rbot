package com.vishnuprasadv.rbot.online.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.ParentReference;
import com.vishnuprasadv.rbot.online.OnlineStorageService;

@Service(value = "driveImpl")
public class GoogleDriveStorage implements OnlineStorageService {

	private static Logger log = LoggerFactory.getLogger(GoogleDriveStorage.class);

	@Value("${drive.access.applicationname}")
	private String applicationName;

	@Value("${drive.access.parentfolderid}")
	private String parentFolderId;

	private Drive drive = null;

	private boolean isReady = false;

	@Value("${drive.access.imagecontenttype}")
	private String imageContentType;

	@Value("${drive.access.credentialpath}")
	private String credentialPath;

	private void initialize() {
		try (InputStream in = GoogleDriveStorage.class.getResourceAsStream("/client_secret.json")) {
			List<String> scopes = Arrays.asList(DriveScopes.DRIVE);
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in));
			HttpTransport securedHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
			java.io.File credentialStorage = new java.io.File(System.getProperty("user.home"), credentialPath);
			FileDataStoreFactory credentialStorageStoreDirectory = new FileDataStoreFactory(credentialStorage);
			GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(securedHttpTransport,
					jsonFactory, clientSecrets, scopes).setDataStoreFactory(credentialStorageStoreDirectory)
							.setAccessType("offline").build();

			Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
					.authorize("user");
			drive = new Drive.Builder(securedHttpTransport, jsonFactory, credential).setApplicationName(applicationName)
					.build();
			log.info("Authentication successful.");

		} catch (Exception e) {
			log.error("Error authorizing Google drive", e);
		}
	}

	@Override
	public void uploadImage(String filePath) throws Exception {
		if (!isReady) {
			log.info("Google drive. Initializing the authentication");
			this.initialize();
		}

		java.io.File uploadFile = new java.io.File(filePath);
		File fileMetadata = new File();
		fileMetadata.setTitle(uploadFile.getName());
		fileMetadata.setParents(Arrays.asList(new ParentReference().setId(parentFolderId)));
		FileContent mediaContent = new FileContent(imageContentType, uploadFile);
		Drive.Files.Insert insert = drive.files().insert(fileMetadata, mediaContent);
		MediaHttpUploader uploader = insert.getMediaHttpUploader();
		uploader.setDirectUploadEnabled(true);
		uploader.setProgressListener(null);
		insert.execute();
	}

}
