FROM amazoncorretto:21-alpine AS builder
WORKDIR /source
COPY . .
RUN ./gradlew clean bootJar

FROM amazoncorretto:21-alpine AS final
LABEL authors="JP"
LABEL version="1.0"
WORKDIR /app
COPY --from=builder /source/build/libs/posto-combustivel*.jar posto-combustivel.jar
ENV PORT=8080
EXPOSE 8080
CMD ["java", "-jar", "posto-combustivel.jar"]