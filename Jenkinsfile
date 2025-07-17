pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10'    // Tên Maven đúng như bạn đã cấu hình trong Jenkins > Global Tool Configuration
        jdk 'jdk 21'            // Tên JDK đúng như bạn đã cấu hình trong Jenkins
    }

    environment {
        APP_NAME = "product-manager"
        JAR_FILE = "target/${APP_NAME}.jar"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/DuVanSang/Lib_BE.git'
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
                bat 'start /B java -jar %JAR_FILE%'
            }
        }
    }
}
