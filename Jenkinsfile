pipeline {
    agent any

    tools {
        maven 'maven-3.9.10'
        jdk 'jdk 21'
    }

    environment {
        APP_NAME = "product-manager"
        JAR_FILE = "target/${APP_NAME}.jar"
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
                bat 'start /B java -jar %JAR_FILE%'
            }
        }
    }
}
