package com.vishnuprasadv.rbot.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserializer {
	private Deserializer() {

	}

	public static <T> T deserialize(String json, Class<T> className) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, className);
	}
}
