######################################
# Base image for compiling container #
######################################
FROM maven:3.8.2-openjdk-16 as builder

# Define workdir where commands will be executed
WORKDIR /project

# Copy project dependencies
COPY pom.xml /project/

# Copy project code
COPY src /project/src

# Compile project
RUN mvn package

########################################
# Base image for application container #
########################################
FROM openjdk:16.0.2-jdk-slim

# Define work dir where JAR will be located
WORKDIR /usr/src/app/

# Copy JAR from compiling container
COPY --from=builder /project/target/*.jar /usr/src/app/

# Port
EXPOSE 8080

# Command executed with docker run
CMD [ "java", "-jar", "e-commerce-0.0.1-SNAPSHOT.jar" ]