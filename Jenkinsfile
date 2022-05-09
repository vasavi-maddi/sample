pipeline {
    agent any
    stages {
        stage('Clean') {
           steps{
               echo "######################## Cleaning the project"
           }
        }
        stage('Compile') {
           steps{
               echo "######################## Compile the project"
           }
        }
        stage('Sonar Scan') {
            // Run the sonar scan
            steps {
                echo "######################## Sonar Scan"
               }
        }
        stage('Package Archieve') {
            steps{
                echo "######################## Packing Project Archieve";
            }
        }
    }
}