FROM openjdk:8-jdk-alpine
MAINTAINER Team
COPY target/ws-retail-orderservice.jar app.jar
ENTRYPOINT ["java", "-jar","/ws-retail-orderservice.jar"]

#EXPOSE 8008