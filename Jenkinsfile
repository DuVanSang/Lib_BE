
// pipeline {
//     agent any

//     tools {
//         maven 'maven-3.9.10'
//         jdk 'jdk 21'
//     }

//     environment {
//         JAR_FILE = "target/library-management-backend-0.0.1-SNAPSHOT.jar"
//     }

//     stages {
//         stage('Build') {
//             steps {
//                 bat 'mvn clean package -DskipTests'
//             }
//         }

//         stage('Test') {
//             steps {
//                 bat 'mvn test'
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 bat 'echo Deploying %JAR_FILE%...'
//                 bat 'start /B java -jar %JAR_FILE%'
//             }
//         }
//     }
// }




pipeline {
    agent any

    tools {
        maven 'maven-3.9.10'
        jdk 'jdk 21'
    }

    environment {
        IMAGE_NAME = "duvansang/library-management-backend"
        IMAGE_TAG = "latest"
        DOCKERHUB_CREDENTIALS = 'dockerhub-credentials' // Đảm bảo đúng ID credentials đã tạo
    }

    stages {
        stage('Build JAR') {
            steps {
                bat 'mvn clean package '
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t %IMAGE_NAME%:%IMAGE_TAG% ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKERHUB_CREDENTIALS, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
                        bat "docker login -u %DOCKERHUB_USER% -p %DOCKERHUB_PASS%"
                        bat "docker push %IMAGE_NAME%:%IMAGE_TAG%"
                    }
                }
            }
        }

        stage('Deploy Container') {
            steps {
                script {
                    bat "docker rm -f library-backend || exit 0"
                    bat "docker run -d -p 8081:8081 --name library-backend %IMAGE_NAME%:%IMAGE_TAG%"
                }
            }
        }
    }
}
