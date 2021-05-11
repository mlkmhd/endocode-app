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

/*
        stage('deploy to kubernetes with kubectl') {
            steps {
                script {
                    sh 'kubectl apply -f k8s-deployment.yaml --kubeconfig /root/kubeconfig'
                    sh 'kubectl rollout restart deployment endocode-app --kubeconfig /root/kubeconfig'
                }
            }
        }
*/

        stage('deploy to kubernetes using terraform') {
            steps {
                script {
                    sh 'terraform init'
                    sh 'terraform apply'
                }
            }
        }


    }
}
