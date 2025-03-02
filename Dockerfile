# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy only necessary files for a more efficient build
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (This speeds up builds by caching dependencies)
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the entire project
COPY src src

# Build the JAR file using Maven
RUN ./mvnw clean package -DskipTests

# Copy the JAR file to run
RUN cp target/*.jar app.jar

# Expose the application port
EXPOSE 1222

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
