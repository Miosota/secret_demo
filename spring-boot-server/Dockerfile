FROM openjdk:24-ea-21-jdk
WORKDIR /app
COPY ../target/secret_demo-1.0-SNAPSHOT.jar /app/secret_demo.jar
ENTRYPOINT [ "java", "-jar",  "secret_demo.jar"]