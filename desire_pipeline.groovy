pipeline {
    agent any

    stages {
        stage('cloning repo ... ') {
            steps {
                git 'https://github.com/beerkeeper/python-ip-script/'
            }
        }
        
        stage('build'){
            agent{
                docker { 
                    image 'python:2' 
                    reuseNode true
                }    
            }
            steps{
                sh "pip install -r $WORKSPACE/requirements.txt"
                sh "python $WORKSPACE/main.py"
            }
        }
            
    }
    post{
        success{
            echo "Cool :)"
        }
    }
}