FROM openjdk:8-jdk-alpine
MAINTAINER vleon
VOLUME /tmp
EXPOSE 8090
COPY ./target/sample-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]