#FROM java:8
FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="jluiscalderon91@hotmmail.com"
WORKDIR /myapp
COPY target/apicliente-main-0.0.1-SNAPSHOT.jar /myapp/my-app.jar
ENTRYPOINT ["java","-jar","my-app.jar"]