package com.mobilesys;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MiddlewareApplication {
	
//	private static final Logger logger = LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {

		ApplicationContext context =
				new ClassPathXmlApplicationContext(
						"/si-config.xml"
				);
	}
}
