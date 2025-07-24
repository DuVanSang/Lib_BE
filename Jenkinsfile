pipeline {
    agent any

    tools {
        maven 'maven-3.9.10'
        jdk 'jdk 21'
    }

    environment {
        JAR_FILE = "target/library-management-backend-0.0.1-SNAPSHOT.jar"
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                bat 'echo Deploying %JAR_FILE%...'
                rem Chạy foreground, ghi log
                start /B java -jar %JAR_FILE% > app.log 2>&1
                rem Chờ app khởi động (15 giây)
                timeout /T 15
                rem Kiểm tra port 8081
                powershell -Command "if ((Test-NetConnection -ComputerName localhost -Port 8081).TcpTestSucceeded) { Write-Host 'API is UP' } else { Write-Host 'API NOT RESPONDING'; exit 1 }"
            }
        }
    }
}
