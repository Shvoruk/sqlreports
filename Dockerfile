FROM openjdk:17-jdk-alpine

WORKDIR /tmp

COPY target/sqlreports-0.1.0-SNAPSHOT.jar /tmp/sqlreports.jar

ENTRYPOINT ["java", "-jar", "/tmp/sqlreports.jar"]