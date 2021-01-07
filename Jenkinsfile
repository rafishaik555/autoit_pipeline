pipeline {
    agent any
    stages {
        stage ('SCM Checkout'){
            steps {
                git 'https://github.com/rafishaik555/autoit_pipeline'
            }
            
        }
        stage ('Compile Stage') {

                       def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
                    sh "${mvnHome}/bin/mvn package"
            
        }
        stage ('Testing Stage') {

            steps {
               sh 'mvn test'
            }
        }
        stage ('Install Stage') {
            steps {
                sh 'mvn install'
            }
        }
    }
}
