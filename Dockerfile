# Etapa de construcción
FROM maven:3.2.0-openjdk-17 as BUILDER
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src
RUN mvn clean package

# Etapa de producción
FROM adoptopenjdk:17-jre-slim
WORKDIR /app/
COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar
