package com.devops.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// To start H2 TCP server on Spring Boot application startup?
		Starters.startH2Server();
		SpringApplication.run(DemoApplication.class, args);
	}

}
