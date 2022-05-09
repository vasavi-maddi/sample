pipeline {
    agent any
    environment {
       PATH = "C:\\WINDOWS\\SYSTEM32"
    }
    tools { 
      maven 'GD_MAVEN'
      jdk 'GD_JDK' 
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
                bat 'mvn verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=37b856ddeb9ca706e0392f51b051b0021aaf2531'
            }
        }
        stage('Package Archieve') {
            steps{
                echo "######################## Packing Project Archieve"
                bat 'mvn package'
            }
        }
    }
}