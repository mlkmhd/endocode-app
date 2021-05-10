FROM openjdk:8-jdk

WORKDIR /app

ADD target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
