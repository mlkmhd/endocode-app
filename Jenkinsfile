pipeline {
    
    agent { 
        docker { 
            image 'maven:3.3.3' 
            args '--tmpfs /.config'
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
