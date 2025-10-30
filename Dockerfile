# Etapa 1: Build
FROM gradle:8.5-jdk21 AS builder

WORKDIR /app

# Copiar archivos de configuración de Gradle
COPY build.gradle settings.gradle gradle.properties ./
COPY gradle ./gradle

# Descargar dependencias
RUN gradle dependencies --no-daemon

# Copiar código fuente
COPY src ./src
COPY envios.csv ./

# Compilar aplicación
RUN gradle bootJar --no-daemon -x test

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar JAR compilado desde la etapa de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Copiar archivo CSV de datos
COPY envios.csv ./

# Exponer puerto
EXPOSE 8082

# Variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando de ejecución
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
