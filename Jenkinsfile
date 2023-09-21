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
        stage("Deploying to Staging Server"){
            steps {
                build job: "Deploy_Application_Staging_Server"
            }
        }
    }
}