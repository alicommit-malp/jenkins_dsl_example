# DevOps, Jenkins DSL job simplified

## In Short
The Jenkins DSL job is a job which will create another job(s)/pipeline(s)/etc but why create a job to create a job you may ask well, in this way your desired job will be stored as a script in a version control repository therefore you have the ability to version it and have a history of its changes, which was the motivation behind the creation of the DSL jobs in order to achieve configuration as code in Jenkins.  

all you need is located in github at [alicommit-malp/jenkins_dsl_example](https://github.com/alicommit-malp/jenkins_dsl_example)

### Steps
- [install Jenkins](https://jenkins.io/download/)
  - Alternatively you can [install docker](https://docs.docker.com/v17.12/install/) and run run [this](https://github.com/alicommit-malp/jenkins_dsl_example/blob/master/jenkins_docker.sh) 
- install [job-dsl-plugin](https://github.com/jenkinsci/job-dsl-plugin) , [how?](https://jenkins.io/doc/book/managing/plugins/)
- create a script in groovy language [like this](https://github.com/alicommit-malp/jenkins_dsl_example/blob/master/dsl_job.groovy)
- place it in any version control repository, [how?](https://help.github.com/en/github/getting-started-with-github/create-a-repo)  
- create a Freestyle project in Jenkins called Seed_JOB
- feed the created job with the location of the script in the repository
- build the Seed_JOB, Jenkins will run your script when you build it 

and your your DSL generated job(s)/pipeline(s)/etc are ready to be built.

## In Detail
After the installation of the Jenkins on your system or running it in your docker daemon got the following link (supposing that you have installed Jenkins with its default port)

```
http://localhost:8080/newJob
```

Here you can create a Seed job, which is basically the job which is going to fetch the script for the actual job in a given version control repository 

![Jenkins new Seed job](https://thepracticaldev.s3.amazonaws.com/i/if2yxl8xlkth8mdcf17h.png)

then you need to specify the source control technology which you are using plus the link to your repository and if your repository is not public your credentials as well

![DSL job source control management](https://thepracticaldev.s3.amazonaws.com/i/m6vckeawi0pwykj0q33l.png)

afterwards, and supposing that you have installed the job-dsl-plugin 

![DSL plugin selection in Jenkins](https://thepracticaldev.s3.amazonaws.com/i/tf0s7u3fjoyydkwmzcdo.png)

you will provide the build step with relative path to the script which is going to generate your job(s)/pipeline(s)/etc


```groovy
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
```

![Build step Jenkins DSL job](https://thepracticaldev.s3.amazonaws.com/i/ejq74m17hgk7nqwezgq3.png)

save the job, and build it, and then if you visit the Jenkins dashboard you will see that there is a job which has been added programmatically to the list of the jobs 

![Jenkins dashboard show all jobs](https://thepracticaldev.s3.amazonaws.com/i/vshybl1r3dy9eq175adf.png)

Build the created job 

There you have it, a simple tutorial to Jenkins DSL jobs.
Happy coding :)

all you need is located in github at [alicommit-malp/jenkins_dsl_example](https://github.com/alicommit-malp/jenkins_dsl_example)
