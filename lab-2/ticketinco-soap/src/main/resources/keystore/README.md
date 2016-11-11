## Creacion de clave publica/privada para cliente y servidor

A continuacion se indican los comandos a ser ejecutados para generar las 4 claves
contenidas en este directorio.

- Creacion de clave privada en su respectivo keystore

```{bash}
keytool -genkey -alias middleware-lab2-wsse -keypass changeit -keystore ~/server-privatestore.jks -storepass changeit -keyalg RSA
keytool -genkey -alias client-middleware-lab2-wsse -keypass changeit -keystore ~/client-privatestore.jks -storepass changeit -keyalg RSA
```

- Auto firmado de clave privada

```{bash}
keytool -selfcert -alias middleware-lab2-wsse -keystore ~/server-privatestore.jks
keytool -selfcert -alias client-middleware-lab2-wsse -keystore ~/client-privatestore.jks
```

- Creacion de clave publica en archivo `.rsa`

```{bash}
keytool -export -alias middleware-lab2-wsse -file server-middleware-lab2-wsse-pub.rsa -keystore ~/server-privatestore.jks
keytool -export -alias client-middleware-lab2-wsse -file client-middleware-lab2-wsse-pub.rsa -keystore ~/client-privatestore.jks
```

- Creacion de nuevo keystore el cual importa la clave publica

```{bash}
keytool -import -alias middleware-lab2-wsse -file server-middleware-lab2-wsse-pub.rsa -keystore ~/server-publicstore.jks
keytool -import -alias client-middleware-lab2-wsse -file client-middleware-lab2-wsse-pub.rsa -keystore ~/client-publicstore.jks
```
Estas claves permiten aplicar el [sistema de criptografia con clave publica](https://en.wikipedia.org/wiki/Public-key_cryptography),
y con ellas somos capaces de firmar y/o cifrar los mensajes SOAP. 

Para la integracion de estas claves en el estandar WS-Security utilizando el framework cxf
ver la siguiente [documentacion](http://cxf.apache.org/docs/ws-security.html).