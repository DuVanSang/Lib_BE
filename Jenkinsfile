pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'     // Tên Maven trong Jenkins Global Tools
        jdk 'JDK 21'            // Tên JDK đã cài đặt trong Jenkins
    }

    environment {
        APP_NAME = "product-manager"
        
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
                bat 'echo Deploying ${JAR_FILE}...'
                // Ví dụ deploy bằng java -jar
                bat 'nohup java -jar ${JAR_FILE} &'
            }
        }
    }
}
