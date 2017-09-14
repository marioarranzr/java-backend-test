package com.test.java.lampkicking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RoombaApp {

	public static void main(String[] args) {
		SpringApplication.run(RoombaApp.class, args);
	}

}
