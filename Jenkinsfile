pipeline {
    agent any
	  tools {
    	tool name: 'MAVEN_HOME', type: 'maven'
  }

    stages {
        stage ('SCM Checkout'){
            steps {
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            }
            
        }
        stage ('Compile Stage') {
			      steps {
       			 sh 'mvn clean compile'
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
