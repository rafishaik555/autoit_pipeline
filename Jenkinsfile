node {
        stage ('SCM Checkout'){
            
                git 'https://github.com/rafishaik555/autoit_pipeline.git'
            
            
        }
        stage ('Clean Stage') {
		    	

	
				      def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
				      bat "${mvnHome}/bin/mvn clean"
				      echo 'clean MVN'
      
					
        }
        stage ('Compile Stage') {

           
               echo 'Compile MVN'
		     def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
				      bat "${mvnHome}/bin/mvn compile"
				      
           
        }
        stage ('Install Stage') {
           
 		echo 'test MVN'
	   	def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
				      bat "${mvnHome}/bin/mvn test"
			
        }
    
}
