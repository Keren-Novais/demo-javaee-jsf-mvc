#!groovy

def PROJECT_REPOSITORY = "https://github.com/Keren-Novais/demo-javaee-jsf-mvc.git"
def PROJECT_BRANCH = "master"
def SCM_CREDENTIAL = "github-keren"

pipeline {
  
  agent any
  
  tools{
      jdk "JAVA_11"
      maven "MAVEN_3"
    }
  
  options {
    timestamps()
    buildDiscarder(logRotator(numToKeepStr:'3'))
   }
  
  stages {
    
    stage("Clone Application Repository"){
          steps {
            sh 'git config --global http.sslVerify false'
            timeout(time: 2, unit: "MINUTES") {
              git branch: "${PROJECT_BRANCH}",
                credentialsId: "${SCM_CREDENTIAL}",
                url: "${PROJECT_REPOSITORY}"
            }
          }           
        }
    
    stage("Build Application (Maven)"){
          steps {
            sh "mvn clean package -DskipTests"
          }
        }
    
  }
  
}
