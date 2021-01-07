pipeline {
    agent any
	  tools {
  }

    stages {
        stage ('SCM Checkout'){
            steps {
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            }
            
        }
        stage ('Compile Stage') {
		    	def mvnHome = name: 'MAVEN_HOME', type: 'maven'

			      steps {
				      sh "${mvnHome}/bin/mvn clean"
				      echo 'clean MVN'
      }
	
					
        }
        stage ('Testing Stage') {

            steps {
               echo 'test MVN'
		    //sh 'mvn test'
            }
        }
        stage ('Install Stage') {
            steps {
 		echo 'install MVN'
	    }
        }
    }
}
