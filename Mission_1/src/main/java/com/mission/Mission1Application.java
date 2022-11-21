package com.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class Mission1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chapter01Application.class, args);
		SpringApplication application =
			new SpringApplication(Mission1Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
		
		System.out.println("Done");
	}

}
