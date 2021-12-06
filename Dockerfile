FROM openjdk:8-alpine
WORKDIR app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]