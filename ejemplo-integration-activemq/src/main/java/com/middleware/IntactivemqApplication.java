package com.middleware;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.xml.bind.JAXBException;

@SpringBootApplication
public class IntactivemqApplication {

	public static void main(String[] args) throws JAXBException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/integration/si-config.xml");
	}
}