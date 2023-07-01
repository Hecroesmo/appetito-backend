# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app
# VOLUME /tmp
# RUN
# COPY target/*.jar appetito-backend-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","/appetito-backend-0.0.1-SNAPSHOT.jar"]


# Use a base image with Java and Maven installed
# FROM maven:3.8.4-openjdk-11-slim AS build

# # Set the working directory in the container
# WORKDIR /app

# # Copy the pom.xml file to the container
# COPY pom.xml .

# # Download the dependencies defined in the pom.xml
# RUN mvn dependency:go-offline -B

# # Copy the source code to the container
# COPY src ./src

# # Build the application
# RUN mvn package -DskipTests

# # Use a lightweight base image with Java
# FROM openjdk:11-jre-slim

# # Set the working directory in the container
# WORKDIR /app

# # Copy the built JAR file from the previous build stage
# COPY --from=build /app/target/appetito-backend-0.0.1-SNAPSHOT.jar .

# # Set the command to run the Spring Boot application
# CMD ["java", "-jar", "appetito-backend-0.0.1-SNAPSHOT.jar"]


# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base as development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=mysql", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/appetito-backend*.jar /appetito-backend-0.0.1-SNAPSHOT.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/appetito-backend-0.0.1-SNAPSHOT.jar"]