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
                bat 'start /B java -jar %JAR_FILE%'
            }
        }
    }
}
