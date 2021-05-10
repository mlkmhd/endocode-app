FROM maven:3.8.1-jdk-11

WORKDIR /app

ADD . /app

RUN mvn clean package



FROM openjdk:8-jdk

WORKDIR /app

COPY --from=0 /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
