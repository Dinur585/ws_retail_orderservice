# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:8-jdk-alpine
MAINTAINER Team
COPY --from=build /app/target/ws_retail_orderservice-1.0-SNAPSHOT.jar ws-retail-orderservice.jar
ENTRYPOINT ["java", "-jar","ws-retail-orderservice.jar"]

#EXPOSE 8008


