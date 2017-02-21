package com.vishnuprasadv.rbot.services.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnuprasadv.rbot.services.ImageService;
import com.vishnuprasadv.rbot.utils.DataBot;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private DataBot dataBot;

	@Override
	public InputStream fetchImage(String url) throws IOException {
		return dataBot.retrieveStream(url);
	}

}
