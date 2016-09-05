### Spring integration example

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

```{bash}
gradle build
java -jar build/libs/middleware-0.0.1-SNAPSHOT.jar
```

