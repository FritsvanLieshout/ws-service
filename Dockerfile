FROM openjdk:11-jdk-slim

ADD ./target/ws-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/ws-service.jar"]

EXPOSE 8443