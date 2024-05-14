pipeline{
    agent any
    stages {
        stage('#001 - Build Jar of Framework')
        { steps { bat "mvn clean package -DskipTests"} }
        stage('#002 - Build Docker Image')
        { steps {
        environment{
         SERVICE_CREDS = credentials('dockerhub-creds')
        }
        bat 'docker login -u ${SERVICE_CREDS_USR} -p ${SERVICE_CREDS_PSW}'
        bat "docker build -t=rajat725/dockerframework ."} }
        stage('#003 - Push Docker Image to Docker hub')
        { steps { bat "docker push rajat725/dockerframework"} }

    }



}
