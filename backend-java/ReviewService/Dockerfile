# Stage 1: Build the application
FROM maven:3.9.9-amazoncorretto-21-alpine AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and dependencies to the container
COPY pom.xml .

COPY ./ConfigService/pom.xml ./ConfigService/pom.xml
COPY ./PostService/pom.xml ./PostService/pom.xml
COPY ./UserService/pom.xml ./UserService/pom.xml
COPY ./CommentService/pom.xml ./CommentService/pom.xml
COPY ./ReviewService/pom.xml ./ReviewService/pom.xml
COPY ./DiscoveryService/pom.xml ./DiscoveryService/pom.xml
COPY ./GatewayService/pom.xml ./GatewayService/pom.xml

WORKDIR /app/ReviewService

# Download dependencies (this will cache dependencies if the pom.xml hasn't changed)
RUN mvn dependency:go-offline

# Copy the source code
COPY ./ReviewService/src ./src

# Package the application (build the JAR file)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM amazoncorretto:21-alpine

# Set the location of the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/ReviewService/target/review-service.jar .

# Expose the port the app will run on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "review-service.jar"]
