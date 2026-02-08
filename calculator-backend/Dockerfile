# Use a Node-compatible Java image (Java 21 is current LTS)
FROM eclipse-temurin:21

# Set the working directory
WORKDIR /app

# 1. Copy the Maven Wrapper files first
# This allows Docker to cache the 'download dependencies' step
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# 2. Give execution permission to the wrapper and download dependencies
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# 3. Copy the actual source code
COPY src ./src

# 4. Expose the Spring Boot port
EXPOSE 9090

# 5. Run the app using the wrapper
# We use 0.0.0.0 to ensure it listens to requests from other containers
CMD ["./mvnw", "spring-boot:run", "-X"]