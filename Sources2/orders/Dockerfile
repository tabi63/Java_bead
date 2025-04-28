FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn clean install -U

FROM openjdk:21

COPY --from=build /app/target/orders-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
