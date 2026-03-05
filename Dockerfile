FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
COPY src ./src
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean package -DskipTests
RUN rm -rf /root/.m2
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /app/target/booking-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
