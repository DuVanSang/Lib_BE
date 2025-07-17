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
        stage('Clean Old App') {
            steps {
                bat 'taskkill /F /IM java.exe || echo No java process running'
            }
        }

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
                bat 'start /B java -jar %JAR_FILE% > app.log 2>&1'
                bat 'timeout /t 5'
                bat 'netstat -aon | findstr :8081'
            }
        }

        stage('Verify API') {
            steps {
                bat 'curl http://localhost:8081/api/swagger-ui/index.html || echo API not ready yet'
            }
        }
    }
}
