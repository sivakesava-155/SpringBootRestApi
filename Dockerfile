# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from target directory to the container
COPY target/*.jar app.jar

# Expose the application port (change if needed)
EXPOSE 1222

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
