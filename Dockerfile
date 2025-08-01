FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy file cấu hình Maven trước để tận dụng cache
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (cache bước này nếu code không đổi)
RUN ./mvnw dependency:go-offline

# Copy source code vào (chỉ copy src để tránh rebuild khi file ngoài src đổi)
COPY src ./src

# Build ứng dụng
RUN ./mvnw clean package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/library-management-backend-0.0.1-SNAPSHOT.jar"]