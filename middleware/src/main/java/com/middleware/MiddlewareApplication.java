package com.middleware;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MiddlewareApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
						"/META-INF/spring/integration/si-config.xml",
						"/META-INF/spring/integration/datasource.xml"
				);
	}
}
