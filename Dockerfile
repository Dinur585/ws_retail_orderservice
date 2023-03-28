FROM openjdk:8-jdk-alpine
MAINTAINER Team
COPY target/ws_retail_orderservice-1.0-SNAPSHOT.jar ws-retail-orderservice.jar
ENTRYPOINT ["java", "-jar","ws-retail-orderservice.jar"]

#EXPOSE 8008


