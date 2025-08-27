FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/veterinary-clinic-0.0.1-SNAPSHOT.jar /app/veterinary-clinic.jar
ENTRYPOINT ["java","-jar", "veterinary-clinic.jar"]