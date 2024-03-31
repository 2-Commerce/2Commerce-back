# Build Stage
FROM openjdk:17-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build

# Run Stage
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar", "-Dspring.profiles.active=compose"]
