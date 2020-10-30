package com.devops.springboot.demo;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starters {
 
    private static final Logger logger = LoggerFactory.getLogger(Starters.class);
 
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
