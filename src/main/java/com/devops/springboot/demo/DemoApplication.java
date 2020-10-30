package com.devops.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(" Welcome!!");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(" Demonstration ended!!");
	}

}
