package com.chapter05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter5Application {

	public static void main(String[] args) {
		SpringApplication application = 
				new SpringApplication(Chapter5Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
