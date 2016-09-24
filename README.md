# Lab 1 - Middleware

## Links / Referencias

- Ejemplos https://github.com/spring-projects/spring-integration-samples
- Buen ejemplo https://spring.io/blog/2014/11/25/spring-integration-java-dsl-line-by-line-tutorial
- Documentacion http://docs.spring.io/spring-integration/docs/4.3.1.RELEASE/reference/html/
- Gradle https://spring.io/guides/gs/gradle/
- EIP http://www.enterpriseintegrationpatterns.com/

## Instalar

- Instalar java sdk 1.8

- Instalar [sdkman](http://sdkman.io/install.html)

```{bash}
curl -s https://get.sdkman.io | bash
```

Edit bash profile:

```{bash}
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```

- Instalar Gradle con sdkman

```{bash}
sdk install gradle 3.0
```

## Build & Run

- Iniciar ActiveMQ

```{bash}
cd apache-activemq-5.14.0/bin
./activemq console
```

Queda disponible el portal en http://0.0.0.0:8161/

- Build de un proyecto:

```{bash}
gradle build
java -jar build/libs/{proyecto}.jar
```

- Correr cada proyecto por separado en una terminal:

```{bash}
#Tener ActiveMQ activo en un terminal

#Iniciar Middleware
cd middleware
gradle bootRun #Inicia middleware

#Iniciar Cliente generador de ordenes
cd gs-messaging-jms-client
gradle bootRun #Inicia tomcat en el puerto 8080

#Iniciar WebService SOAP

#Iniciar Cliente event driven consumer

#Inciar Polling consumer
```




