pipeline {
    
    agent {
        docker { 
            image 'maven:3.8.1-jdk-11' 
            registryCredentialsId 'dockerid'
        } 
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }

        state('test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Building docker image') {
          steps{
            script {
              docker.build endocode-app
            }
          }
        }
    }
}
