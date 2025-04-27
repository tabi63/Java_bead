# Use the official Maven image to build the app
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml first and download the dependencies (this helps leverage Docker cache)
COPY pom.xml /app

# Copy the src directory after the pom.xml
COPY src /app/src

# Run Maven build to package the application
RUN mvn clean install -U

# Debug step: List the contents of /app/target
RUN ls -la /app/target

# Use an OpenJDK base image for running the app
FROM openjdk:21

# Copy the JAR file from the build stage to the new image
COPY --from=build /app/target/orders-0.0.1-SNAPSHOT.jar /app/app.jar

# Set the working directory in the new container
WORKDIR /app

# Expose port 8080
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "app.jar"]
