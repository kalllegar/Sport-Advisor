FROM docker.io/library/amazoncorretto:19-alpine-jdk

WORKDIR /usr/src/app

COPY ./VERSION ./VERSION
COPY ./target/Sport-Advisor-0.0.1.jar ./app.jar

ENTRYPOINT [ "java", "-jar", "./app.jar" ]

#docker login