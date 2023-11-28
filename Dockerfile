FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:8-jdk-slim

EXPOSE 8080

COPY --from=build target/jsf-demo-1.0-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-jar", "app.war"]
