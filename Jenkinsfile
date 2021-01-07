node {
        stage ('SCM Checkout'){
            
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            
            
        }
        stage ('Compile Stage') {
		    	

	
				      def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
				      sh "${mvnHome}/bin/mvn clean"
				      echo 'clean MVN'
      
					
        }
        stage ('Testing Stage') {

           
               echo 'test MVN'
		    //sh 'mvn test'
           
        }
        stage ('Install Stage') {
           
 		echo 'install MVN'
	   
        }
    
}
