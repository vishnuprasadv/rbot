package com.vishnuprasadv.rbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({ "com.vishnuprasadv.rbot" })
@PropertySource("classpath:credentials.properties")
public class RbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbotApplication.class, args);
	}
}
