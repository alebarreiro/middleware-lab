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

## Configuracion Previa

### Usuarios Tomcat
La autenticacion con la api pagosYa se realiza con http Basic
utilizando los usuarios del repositorio de tomcat.
Por lo que se deben agregar los siguientes usuarios al
archivo `$CATALINA_BASE/conf/tomcat-users.xml`

```{xml}
<user username="mid_user" password="mid_user" roles="tomcat"/>
<user username="ticket_inco_user" password="ticket_inco_user" roles="tomcat" />
```

### SSL

- Correr el siguiente comando, eligiendo como contraseña `changeit`

```{bash}
$JAVA_HOME/bin/keytool -genkey -alias tomcat -keyalg RSA
```

Esto debe generar un archivo `.keystore` en el directorio home del usuario

- Agregar el siguiente conector al archivo `$CATALINA_BASE/conf/server.xml`
```{xml}
<Connector
       protocol="org.apache.coyote.http11.Http11NioProtocol"
       port="8443" maxThreads="200"
       scheme="https" secure="true" SSLEnabled="true"
       keystoreFile="{HOME_USER}/.keystore" keystorePass="changeit"
       clientAuth="false" sslProtocol="TLS"/>
```

Es importante modificar el valor `HOME_USER` de keystoreFile por la ruta absoluta
al directorio home del usuario.

Luego de reiniciar el servidor, probar acceder a la ruta
https://localhost:8443/manager. De esta manera tendremos SSL configurado
con un certificado autosignado (no es valido ante ninguna unidad certificadora).

---

> NOTA: No olvidar reiniciar el servidor luego de realizar las configuraciones.

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


