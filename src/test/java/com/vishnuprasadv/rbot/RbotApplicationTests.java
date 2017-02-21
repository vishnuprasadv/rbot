package com.vishnuprasadv.rbot;

import javax.annotation.Resource;

import org.assertj.core.api.Fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vishnuprasadv.rbot.online.OnlineStorageService;
import com.vishnuprasadv.rbot.schedulable.Engine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RbotApplicationTests {

	@Autowired
	private Engine engine;

	@Resource(name = "driveImpl")
	private OnlineStorageService storage;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUpload() {
		try {
			engine.scheduledWork();
			engine.uploadImages();
		} catch (Exception e) {
			Fail.fail("exception");
			e.printStackTrace();
		}
	}

	@Test
	public void testDrive() {
		try {
			storage.uploadImage("~/images/rodgers92956053.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
