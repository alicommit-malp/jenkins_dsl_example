# Jenkins DSL job simplified

In short the Jenkins DSL job is a job which will create another job(s)/pipeline and etc. but why create a job to create a job you may ask. well as in this way your desire job will be stored as a script in a version control repository therefore you have the ability to version it and have the history of its changes, which was the motivation of the creation of DSL jobs. 

## Steps
- [install Jenkins](https://jenkins.io/download/)
  - Alternative install docker and run run this 
- install [job-dsl-plugin](https://github.com/jenkinsci/job-dsl-plugin) 
- create a script in groovy language [like this](https://github.com/alicommit-malp/jenkins_dsl_example/blob/master/dsl_job.groovy)
- place it in any version control repository [how ?](https://help.github.com/en/github/getting-started-with-github/create-a-repo)  
- create a Freestyle project in Jenkins called Seed_JOB
- feed the created job with the location of the script in the repository
- build the Seed_JOB, Jenkins will run your script when you build it 

and your 


http://localhost:8080/newJob

![Jenkins new Seed job](https://thepracticaldev.s3.amazonaws.com/i/if2yxl8xlkth8mdcf17h.png)

![Alt Text](https://thepracticaldev.s3.amazonaws.com/i/m55d9536kxr3zlom9wrh.png)

![Alt Text](https://thepracticaldev.s3.amazonaws.com/i/ejq74m17hgk7nqwezgq3.png)

save 

Build the Seed_Job

![Alt Text](https://thepracticaldev.s3.amazonaws.com/i/vpczagzmtxo12hiqwske.png)

It will create the pipeline 

Build the created job 