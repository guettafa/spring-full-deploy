pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo '=== Building ==='
                git branch: 'dev', credentialsId: '9b909b00-c269-4791-a768-bfeccd4b0263', url: 'https://github.com/guettafa/spring-full-deploy.git'
            }
        }
        stage('Test') {
            steps {
                echo '=== Testing ==='
            }
        }
        stage('Deploy') {
            steps {
                echo '=== Deployment === '
                sh 'docker-compose up'
            }
        }
    }
}