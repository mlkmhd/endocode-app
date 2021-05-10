# Getting Started

## Build the app

this is a java application and you can build it with the following code:

```bash
$ mvn clean package
$ mv target/*.jar target/app.jar
$ java -jar target/app.jar
```

## Build the Docker image

```bash
$ docker build . --no-cache endocode-app 
$ docker run -p 8080:8080 -d endocode-app 
```


