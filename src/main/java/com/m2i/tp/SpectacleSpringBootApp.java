package com.m2i.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpectacleSpringBootApp extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpectacleSpringBootApp.class, args);

        System.out.println("http://localhost:8080/spectacleSpringBoot");
	}

}
