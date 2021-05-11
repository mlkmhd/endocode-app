pipeline {

    environment {
        imagename = "mlkbenjamin/endocode-app"
        registryCredential = 'dockerid'
        dockerImage = ''
    }
    
    agent any

    stages {

        stage('building docker image') {
          steps{
            script {
              dockerImage = docker.build imagename
            }
          }
        }

        stage('deploy image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                        dockerImage.push('latest')
                    }
                }
            }
        }

    }
}
