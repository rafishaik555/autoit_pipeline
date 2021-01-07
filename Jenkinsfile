pipeline {
    agent any
    stages {
        stage ('SCM Checkout'){
            git 'https://github.com/rafishaik555/autoit_pipeline'
        }
        stage ('Compile Stage') {

            steps {
               sh 'mvn package'
            }
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
