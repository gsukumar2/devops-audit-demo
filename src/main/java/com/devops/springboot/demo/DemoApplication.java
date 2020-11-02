package com.devops.springboot.demo;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	 
	public static void main(String[] args) {
		// To start H2 TCP server on Spring Boot application startup
		startH2Server();
		SpringApplication.run(DemoApplication.class, args);
	}

    /**
     * To start TCP server for H2 database
     */
    public static void startH2Server() {
        try {
            Server h2Server = Server.createTcpServer().start(); // key code
            if (h2Server.isRunning(true)) {
                logger.info("H2 server was started and is running.");
            } else {
                throw new RuntimeException("Could not start H2 server.");
            }
        } catch (SQLException  e) {
            throw new RuntimeException("Failed to start H2 server: ", e);
        }
    }

}
