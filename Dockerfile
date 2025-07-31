# Sử dụng image Java 17
FROM eclipse-temurin:17-jdk

# Thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ mã nguồn
COPY . .

# Biên dịch ứng dụng
RUN ./mvnw clean package -DskipTests

# Mở cổng 8081 cho ứng dụng
EXPOSE 8081

# Chạy ứng dụng từ file JAR đã build
CMD ["java", "-jar", "target/library-management-backend-0.0.1-SNAPSHOT.jar"]
