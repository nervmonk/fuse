FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/fuse-integration-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]