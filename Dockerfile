# Build Stage
FROM openjdk:17-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build

# Run Stage
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/back-0.0.1-SNAPSHOT.jar /app/back-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/back-0.0.1-SNAPSHOT.jar"]
