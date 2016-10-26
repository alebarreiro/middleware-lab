# Lab 2 - Middleware

## Links / Referencias

## Instalar

- Instalar java sdk 1.8

- Instalar [ActiveMQ](http://activemq.apache.org/activemq-5140-release.html) 

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

- Tener instalado PostgreSQL y seguir instrucciones en ticketinco-soap/src/main/resources/sql

## Build & Run

Build .war
```{bash}
gradle clean build
```

Correr servidor con tomcat 
```{bash}
gradle tomcatRun
```

## Integrantes

### Grupo 12

 - Barreiro Deminco, Alejandro
 - Cabrera Gonzalez, Anthony Martin
 - Davila Cuevas, Mauricio Fabian
 - Oyharzabal Masares, Leonardo


