package com.vishnuprasadv.rbot.services;

import java.util.List;

import com.vishnuprasadv.rbot.models.ImageFile;
import com.vishnuprasadv.rbot.source.ImageSource;

@FunctionalInterface
public interface DataService {
	List<ImageFile> fetchImageDetails(ImageSource imageSource);
}