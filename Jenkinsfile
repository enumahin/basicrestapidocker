pipeline{
    agent any
    stages {
        stage("Building Application"){
            steps{
                sh 'mvn clean package'
            }
            post {
                    success {
                        echo "Archiving Artifact"
                        sh "mv target/*.war target/basicrestapi.war"
                        archiveArtifacts artifacts: "target/basicrestapi.war"
                    }
                }
        }
        stage("Create docker image"){
            steps {
                sh "mvn spring-boot:build-image"
            }
        }
        stage("Pushing docker image to docker hub"){
            steps {
                sh 'echo ${env.BUILD_ID}'
                sh "docker push basicrestapidocker:${env.BUILD_ID}"
            }
        }
    }
}