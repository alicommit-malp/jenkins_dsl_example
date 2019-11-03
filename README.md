# Notes For the BeerKeeper

```
docker run \
-u root \
--rm \
-d \
-p 8080:8080 \
-p 50000:50000 \
-v jenkins-data:/var/jenkins_home \
-v /var/run/docker.sock:/var/run/docker.sock \
jenkinsci/blueocea
```

![Jenkins new Seed job](https://thepracticaldev.s3.amazonaws.com/i/if2yxl8xlkth8mdcf17h.png)
![DSL job source control](https://thepracticaldev.s3.amazonaws.com/i/qn9heobq1utne2us2ks0.png)
![Jenkins build step for DSL script](https://thepracticaldev.s3.amazonaws.com/i/ejq74m17hgk7nqwezgq3.png)
![pipeline created by DSL](https://thepracticaldev.s3.amazonaws.com/i/kz4g5hl8oquar05ymqxe.png)
```
Console Output

Started by user ali alp
Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/jenkins_home/workspace/python_dsl_job_example
[Pipeline] {
[Pipeline] stage
[Pipeline] { (cloning repo ... )
[Pipeline] git
No credentials specified
 > git rev-parse --is-inside-work-tree # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/beerkeeper/python-ip-script/ # timeout=10
Fetching upstream changes from https://github.com/beerkeeper/python-ip-script/
 > git --version # timeout=10
 > git fetch --tags --force --progress -- https://github.com/beerkeeper/python-ip-script/ +refs/heads/*:refs/remotes/origin/*
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git rev-parse refs/remotes/origin/origin/master^{commit} # timeout=10
Checking out Revision f876f81c3ed28aa9bc7aa588776b8cd44646d30a (refs/remotes/origin/master)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f f876f81c3ed28aa9bc7aa588776b8cd44646d30a
 > git branch -a -v --no-abbrev # timeout=10
 > git branch -D master # timeout=10
 > git checkout -b master f876f81c3ed28aa9bc7aa588776b8cd44646d30a
Commit message: "Update requirements.txt"
First time build. Skipping changelog.
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (build)
[Pipeline] getContext
[Pipeline] isUnix
[Pipeline] sh
+ docker inspect -f . python:2
.
[Pipeline] withDockerContainer
Jenkins seems to be running inside container 7c35f3fca4c0af6b6845b9e5767ae3cfdb270917f9827f8ab3c18ddddc7be474
$ docker run -t -d -u 0:0 -w /var/jenkins_home/workspace/python_dsl_job_example --volumes-from 7c35f3fca4c0af6b6845b9e5767ae3cfdb270917f9827f8ab3c18ddddc7be474 -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** -e ******** python:2 cat
$ docker top ec80c8a5c425095076be55f9057e393e1219844f5fc18e6f14c3adf9e6d1fb81 -eo pid,comm
[Pipeline] {
[Pipeline] sh
+ pip install -r /var/jenkins_home/workspace/python_dsl_job_example/requirements.txt
DEPRECATION: Python 2.7 will reach the end of its life on January 1st, 2020. Please upgrade your Python as Python 2.7 won't be maintained after that date. A future version of pip will drop support for Python 2.7. More details about Python 2 support in pip, can be found at https://pip.pypa.io/en/latest/development/release-process/#python-2-support
Collecting requests==2.20.0
  Downloading https://files.pythonhosted.org/packages/f1/ca/10332a30cb25b627192b4ea272c351bce3ca1091e541245cccbace6051d8/requests-2.20.0-py2.py3-none-any.whl (60kB)
Collecting idna<2.8,>=2.5
  Downloading https://files.pythonhosted.org/packages/4b/2a/0276479a4b3caeb8a8c1af2f8e4355746a97fab05a372e4a2c6a6b876165/idna-2.7-py2.py3-none-any.whl (58kB)
Collecting urllib3<1.25,>=1.21.1
  Downloading https://files.pythonhosted.org/packages/01/11/525b02e4acc0c747de8b6ccdab376331597c569c42ea66ab0a1dbd36eca2/urllib3-1.24.3-py2.py3-none-any.whl (118kB)
Collecting certifi>=2017.4.17
  Downloading https://files.pythonhosted.org/packages/18/b0/8146a4f8dd402f60744fa380bc73ca47303cccf8b9190fd16a827281eac2/certifi-2019.9.11-py2.py3-none-any.whl (154kB)
Collecting chardet<3.1.0,>=3.0.2
  Downloading https://files.pythonhosted.org/packages/bc/a9/01ffebfb562e4274b6487b4bb1ddec7ca55ec7510b22e4c51f14098443b8/chardet-3.0.4-py2.py3-none-any.whl (133kB)
Installing collected packages: idna, urllib3, certifi, chardet, requests
Successfully installed certifi-2019.9.11 chardet-3.0.4 idna-2.7 requests-2.20.0 urllib3-1.24.3
[Pipeline] sh
+ python /var/jenkins_home/workspace/python_dsl_job_example/main.py
Hello, world!
Your IP address is: 212.2.212.140
You succesfully ran this script!
[Pipeline] }
$ docker stop --time=1 ec80c8a5c425095076be55f9057e393e1219844f5fc18e6f14c3adf9e6d1fb81
$ docker rm -f ec80c8a5c425095076be55f9057e393e1219844f5fc18e6f14c3adf9e6d1fb81
[Pipeline] // withDockerContainer
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Declarative: Post Actions)
[Pipeline] echo
Cool :)
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```