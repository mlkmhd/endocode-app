pipeline {
    
    agent {
        docker { 
            image 'maven:3.8.1-jdk-11' 
            registryCredentialsId 'dockerid'
            args '-v /var/jenkins_home/.m2:/root/.m2'
        } 
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('test') {
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
