pipeline {
    
    agent {

        docker { 
            image 'maven:3.3.3' 
            registryCredentialsId 'dockerid'
        } 
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
