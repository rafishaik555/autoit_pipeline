pipeline {
    agent any
    stages {
        stage ('SCM Checkout'){
            steps {
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            }
            
        }
        stage ('Compile Stage') {
				
					def mvn_version = 'MAVEN_HOME'
				withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
  				sh "mvn clean package"
					}
        }
        stage ('Testing Stage') {

            steps {
               sh "${mvnHome}/bin/mvn test"
            }
        }
        stage ('Install Stage') {
            steps {
                sh "${mvnHome}/bin/mvn install"
            }
        }
    }
}
