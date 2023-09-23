pipeline{
    agent any
    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        ARTIFACT_ID = readMavenPom().getArtifactId()
        VERSION = readMavenPom().getVersion()
        }
    stages {
        stage("Building Application"){
            steps{
                sh 'mvn clean package'
            }
            post {
                    success {
                        echo "Archiving Artifact"
                        sh "mv target/*.war target/${ARTIFACT_ID}.war"
                        archiveArtifacts artifacts: "target/${ARTIFACT_ID}.war"
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
                sh "docker push ${ARTIFACT_ID}:${VERSION}"
            }
        }
    }
}