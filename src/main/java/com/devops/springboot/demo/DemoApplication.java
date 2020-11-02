package com.devops.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		// To start H2 TCP server on Spring Boot application startup?
		//Starters.startH2Server();
		SpringApplication.run(DemoApplication.class, args);
	}
   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	Starters.startH2Server();
        return application.sources(DemoApplication.class);
    }

*/
}
