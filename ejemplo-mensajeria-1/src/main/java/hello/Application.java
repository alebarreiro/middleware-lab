package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("/hello/integration.xml")
public class Application {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = new SpringApplication(Application.class).run(args);
        System.out.println("Hit Enter to terminate");
        System.in.read();
        ctx.close();
    }

    /*
    Although it is common to configure a Spring Integration flow within a larger application, perhaps even a web application,
    there’s no reason that it can’t be defined in a simpler standalone application.
    That’s what you do next, creating a main class that kicks off the integration flow and also declares a handful of beans to support the integration flow.
    You also build the application into a standalone executable JAR file. We use Spring Boot’s SpringApplication to create the application context.
    Since this guide uses an the XML namespace for the integration flow, notice that we use @ImportResource to load it into the application context.
     */
}