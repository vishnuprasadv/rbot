package com.vishnuprasadv.rbot.services.impl;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnuprasadv.rbot.models.Child;
import com.vishnuprasadv.rbot.models.ImageFile;
import com.vishnuprasadv.rbot.models.Model;
import com.vishnuprasadv.rbot.services.DataService;
import com.vishnuprasadv.rbot.source.ImageSource;
import com.vishnuprasadv.rbot.utils.DataBot;
import com.vishnuprasadv.rbot.utils.Deserializer;

@Service
public class DataServiceImpl implements DataService {
	private static Logger log = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	public DataBot dataBot;

	public DataServiceImpl() {
	}

	@Override
	public List<ImageFile> fetchImageDetails(ImageSource imageSource) {
		List<ImageFile> data = new ArrayList<>();
		String urlSuffix = imageSource.getSubreddit() + "/top/.json?sort=top&t=day&limit=50";
		try {
			String json = dataBot.retrieveData(urlSuffix);
			Model result = Deserializer.deserialize(json, Model.class);
			for (Child c : result.getData().getChildren()) {
				if (c.getData().getPreview() != null) {
					ImageFile imageFile = new ImageFile();
					imageFile.setImageSource(imageSource.getSubreddit());
					imageFile.setTitle(c.getData().getTitle());
					imageFile.setAuthor(c.getData().getAuthor());
					imageFile.setTimeStamp(LocalDateTime.now(Clock.systemUTC()));
					imageFile.setImageUrl(c.getData().getPreview().getImages().get(0).getSource().getUrl());
					data.add(imageFile);
				}
			}
		} catch (IOException e) {
			log.error("Exception from DataService", e);
		}
		return data;
	}
}
