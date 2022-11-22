package com.mission2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mission02Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chapter01Application.class, args);
		SpringApplication application =
			new SpringApplication(Mission02Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
		System.out.println("Done");
	}	
}
