pipeline {
    
    agent any

    stages {

        stage('building docker image') {
          steps{
            script {
              docker.build "endocode-app"
            }
          }
        }
    }
}
