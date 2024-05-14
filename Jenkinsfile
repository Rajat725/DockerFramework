pipeline{
    agent any
    stages {
        stage('#001 - Build Jar of Framework')
        { steps { bat "mvn clean package -DskipTests"} }
        stage('#002 - Build Docker Image')
        {
             environment{
         Docker_HUB = credentials('dockerhub-creds')
        }
             steps {
        bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
        bat "docker build -t=rajat725/dockerframework ."} }
        stage('#003 - Push Docker Image to Docker hub')
        { steps { bat "docker push rajat725/dockerframework"} }

    }
	
	post{
	 
	 always {bat "docker logout"}
	
	}



}
