pipeline {
    agent any
    // global env variables
    environment {
        EMAIL_RECIPIENTS = 'gangadhar.parde@revature.com
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Clean') {
           steps{
               echo "######################## Cleaning the project"
               bat 'mvn clean'
           }
        }
        stage('Compile') {
           steps{
               echo "######################## Compile the project"
               bat 'mvn compile'
           }
        }
        stage('Sonar Scan') {
            // Run the sonar scan
            steps {
                echo "######################## Sonar Scan"
                bat 'mvn verify sonar:sonar -Dintegration-tests.skip=true -Dmaven.test.failure.ignore=true -Dsonar.host.url=http://172.17.0.2:9000 -Dsonar.login=37b856ddeb9ca706e0392f51b051b0021aaf2531'
               }
            }
        }
        stage('Package Archieve') {
            steps{
                echo "######################## Packing Project Archieve";
                bat 'mvn package';
            }
            post{
                success {
                    archiveArtifacts 'target/*.jar';
                }
            }
        }
    }
}
post {
        // Always runs. And it runs before any of the other post conditions.
        always {
            // Let's wipe out the workspace before we finish!
            deleteDir()
        }
        success {
            sendEmail("Successful");
        }
        unstable {
            sendEmail("Unstable");
        }
        failure {
            sendEmail("Failed");
        }
    }

def sendEmail(status) {
    echo "######################## Inside SendEmail"
    mail(
            to: "$EMAIL_RECIPIENTS",
            subject: "Build $BUILD_NUMBER - " + status + " (${currentBuild.fullDisplayName})",
            body: "Changes:\n " + getChangeString() + "\n\n Check console output at: $BUILD_URL/console" + "\n")
}