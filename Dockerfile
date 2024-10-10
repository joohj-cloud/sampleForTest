# 1. Build stage
FROM gradle:jdk17 AS build
WORKDIR /app

# 프로젝트의 모든 파일 복사
COPY . .

# Spring Boot 애플리케이션 빌드
RUN gradle clean build -x test --no-daemon

# 2. Run stage (경량화된 OpenJDK 17)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# 빌드된 JAR 파일만 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
