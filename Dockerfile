
FROM amazoncorretto:17-alpine-jdk

MAINTAINER Maurobd

COPY target/proyectoml-0.0.1-SNAPSHOT proyportfolio.jar

ENTRYPOINT ["java", "-jar", "/proyportfolio.jar"]