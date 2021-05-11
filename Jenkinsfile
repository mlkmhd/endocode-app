pipeline {
    
    agent { 
        sh "sudo chown jenkins: -R \$PWD/"

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
