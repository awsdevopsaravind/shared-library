def call(Map pipelineParams) {
personName1 = pipelineParams.getOrDefault('personName', null)
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Cloning Github') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/awsdevopsaravind/ci.git'
                echo 'github repo cloned' + personName1
		
            } 
        }
        stage('Build') {
            steps {
                sh "mvn clean test"
		echo 'build completed'
            }
	}
}
}
}
