pipeline {
    agent any

    stages {
        stage('cloning repo ... ') {
            steps {
                git 'https://github.com/alicommit-malp/jenkins_dsl_example'
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
                sh "pip install -r $WORKSPACE/python/requirements.txt"
                sh "python $WORKSPACE/python/main.py"
            }
        }
            
    }
    post{
        success{
            echo "Cool :)"
        }
    }
}