### Spring integration example

## Instalar

- Instalar java sdk 1.8

- Instalar sdkman

```{bash}
curl -s https://get.sdkman.io | bash
```

Edit bash profile:

```{bash}
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```

- Instalar Gradle

```{bash}
sdk install gradle 3.0
```

## Run

```{bash}
gradle build
java -jar build/libs/gs-integration-0.1.0.jar
```

## Fuente

https://spring.io/guides/gs/integration/#scratch
