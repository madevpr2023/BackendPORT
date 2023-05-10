
FROM amazoncorretto:17-alpine-jdk

MAINTAINER Maurobd

COPY target/proyectoml-0.0.1-SNAPSHOT.jar proyportfolio.jar

ENTRYPOINT ["java", "-jar", "/proyportfolio.jar"]