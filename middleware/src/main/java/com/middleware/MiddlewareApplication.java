package com.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class MiddlewareApplication {
	
	private static final Logger logger = LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {
		logger.error("Test");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("/META-INF/spring/integration/si-config.xml");
	}
}
