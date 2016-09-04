### Spring integration example

## Run

0. Instalar java sdk 1.8

1. Instalar sdkman

```{bash}
curl -s https://get.sdkman.io | bash
```

Edit bash profile:

```{bash}
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```

2. Instalar Grandle

```{bash}
sdk install gradle 3.0
```

3.

```{bash}
grandle build
java -jar build/libs/gs-integration-0.1.0.jar
```


