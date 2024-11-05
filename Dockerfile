#FROM openjdk:17-jdk-alpine
#
#WORKDIR /tmp
#
#COPY target/sqlreports-0.1.0-SNAPSHOT.jar /tmp/sqlreports.jar
#
#ENTRYPOINT ["java", "-jar", "/tmp/sqlreports.jar"]

# Use a Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /tmp

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Run Maven build
RUN mvn clean package -DskipTests

# Use a separate, minimal JDK image for the actual application
FROM openjdk:17-jdk-slim

# Set the working directory for the application
WORKDIR /tmp

# Copy the packaged JAR file from the builder stage
COPY --from=builder /tmp/target/*.jar sqlreports.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "sqlreports.jar"]
