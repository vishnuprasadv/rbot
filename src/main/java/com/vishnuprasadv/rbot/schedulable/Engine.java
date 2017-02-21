package com.vishnuprasadv.rbot.schedulable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vishnuprasadv.rbot.models.ImageFile;
import com.vishnuprasadv.rbot.online.OnlineStorageService;
import com.vishnuprasadv.rbot.repo.ImageFileRepository;
import com.vishnuprasadv.rbot.services.DataService;
import com.vishnuprasadv.rbot.services.ImageService;
import com.vishnuprasadv.rbot.services.StorageService;
import com.vishnuprasadv.rbot.source.ImageSource;
import com.vishnuprasadv.rbot.source.ImageSourceBuilder;

@Service
public class Engine {

	private Logger log = LoggerFactory.getLogger(Engine.class);

	@Autowired
	private ImageFileRepository imageFileRepository;

	@Autowired
	private ImageSourceBuilder imageSourceBuilder;

	@Autowired
	private DataService dataService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private ImageService imageService;

	@Autowired
	@Qualifier(value = "dropBoxImpl")
	private OnlineStorageService onlineService;

	@Scheduled(cron = "0 0 19 * * *")
	public void scheduledWork() throws IOException {
		imageSourceBuilder.buildImageSourcesList();
		for (ImageSource source : imageSourceBuilder.getImageSources()) {
			log.info("Retrieving images from " + source.getSubreddit());
			List<ImageFile> images = dataService.fetchImageDetails(source);
			images.parallelStream().forEach(this::saveImage);
		}
	}

	@Scheduled(cron = "0 30 19 * * *")
	public void uploadImages() throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get("C:/images/"))) {
			List<Path> files = paths.filter(Files::isRegularFile).collect(Collectors.toList());
			files.stream().forEach(this::uploadFile);
		}
	}

	private void uploadFile(Path path) {
		try {
			log.info("uploading image - " + path.toString());
			onlineService.uploadImage(path.toFile().getAbsolutePath());
			log.info("Image uploaded to the service via - " + this.getClass());
		} catch (Exception e) {
			log.error("Error uploading file -" + path.toString(), e);
		}
	}

	private void saveImage(ImageFile image) {
		ImageFile c = imageFileRepository.findByImageUrl(image.getImageUrl());
		if (c == null) {
			log.info("Saving the image " + image.getImageUrl());
			try {
				storageService.persistImage(imageService.fetchImage(image.getImageUrl()), image.getAuthor());
			} catch (IOException e) {
				log.error("Error saving the image", e);
			}
			imageFileRepository.save(image);
			log.info("Saved the image " + image.getImageUrl());
		} else {
			log.info("Image already downloaded | url: " + c.getImageUrl());
		}
	}
}
