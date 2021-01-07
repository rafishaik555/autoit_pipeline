pipeline {
    agent any
	  tools {
    maven 'MAVEN_HOME'
  }

    stages {
        stage ('SCM Checkout'){
            steps {
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            }
            
        }
        stage ('Compile Stage') {
			      steps {
       			 sh 'mvn -B -DskipTests clean package'
      }
	
					
        }
        stage ('Testing Stage') {

            steps {
               echo 'test MVN'
            }
        }
        stage ('Install Stage') {
            steps {
 		echo 'install MVN'
	    }
        }
    }
}
