# Use a base image with Amazon Corretto JDK 11
FROM amazoncorretto:17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project descriptor and build files
COPY . .


# Build the application
RUN ./mvnw package -DskipTests

# Use a lightweight base image with Amazon Corretto JDK 11
FROM amazoncorretto:17-alpine-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the container
COPY --from=build /app/target/spring-boot-template-0.0.1-SNAPSHOT.jar /app/spring-boot-template-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "spring-boot-template-0.0.1-SNAPSHOT.jar"]