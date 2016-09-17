package com.middleware;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

import javax.jms.*;

@SpringBootApplication
public class IntactivemqApplication {

	public static void main(String[] args) throws JMSException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/integration/si-config.xml");

		MessageChannel inputChannel = ctx.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = ctx.getBean("outputChannel", PollableChannel.class);

		inputChannel.send(new GenericMessage<String>("World"));
		System.out.println(outputChannel.receive().getPayload());
	}
}