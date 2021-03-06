pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checkout'
            }
        }

        stage('Build') {
            steps {
                echo 'Clean Build'
                sh 'mvn clean compile -P dev'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing'
                sh 'mvn test'
            }
        }


        stage('Package') {
            steps {
                echo 'Packaging'
                sh 'mvn clean package -P dev'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Build Docker Image'
                sh 'docker build --no-cache -t leon4uk/botmasterzzz-mobile-service:1.0.0 .'
            }
        }

        stage('Push Docker image') {
            steps {
                echo 'Push Docker image'
                withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
                    sh "docker login -u leon4uk -p ${dockerHubPwd}"
                }
                sh 'docker push leon4uk/botmasterzzz-mobile-service:1.0.0'
                sh 'docker rmi leon4uk/botmasterzzz-mobile-service:1.0.0'
            }
        }

        stage('Deploy') {
            steps {
                echo '## Deploy remote ##'
                script {
                    sshagent(credentials: ['second']) {
                        echo '## Deploy remote ##'
                        sh "ssh root@5.189.146.63 docker container ls -a -f name=botmasterzzz-mobile-service -q | ssh root@5.189.146.63 xargs --no-run-if-empty docker container stop"
                        sh 'ssh root@5.189.146.63 docker container ls -a -f name=botmasterzzz-mobile-service -q | ssh root@5.189.146.63 xargs -r docker container rm'
                        sh "ssh root@5.189.146.63 docker rmi --force leon4uk/botmasterzzz-mobile-service:1.0.0"
                        sh 'ssh root@5.189.146.63 docker run -v /home/repository:/home/repository -v /etc/localtime:/etc/localtime --name botmasterzzz-mobile-service -d -p 0.0.0.0:8016:8016 --network=host --restart always leon4uk/botmasterzzz-mobile-service:1.0.0'
                    }
                }
            }
        }
    }
}
