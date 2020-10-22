FROM openjdk:14-alpine
COPY target/repartis-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT [ "java","-jar","app.jar" ]