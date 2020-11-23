# Service Template Project

Service-Template project to build micro-service.

This project is an application skeleton for a micro service  using Java, Spring Boot, and Gradle.
You can use it to quickly bootstrap your  projects and write your first service within minutes.

It's a pre-configured Gradle project containing a sample application and all required dependencies.

## Description

Project contains below modules.

```
- common : Set of all common gradle files to orchestrate build and deploy for local development.

- eks : Set of all YAML files related to deployment on Kubernetes cluster using docker image pushed to artifactory.

- gradle : Provides wrapper to create gradle environment.

- pipeline :Set of files to provide environment specific configuration to orchestrate Jenkins auto build and deployment.

- src/main : All source code related files are placed in this module.

- src/test : All test related files are placed in this module.

- build.gradle : Gradle file to initiate build process by configuring source dependencies.

- Dockerfile : Docker configuration file to create micro-service docker image and push to JFrog Artifactory.

- Jenkinsfile : File to initiate automatic build and deployment using pipeline concept of Jenkins.

```

 ## Getting Started
 
 These instructions will get you a copy of the micro-service project up and running on your local machine for development , testing and deployment to AWS infrastructure purposes. See Reference section to deploy customized application to AWS Infra.

### Prerequisites

Below is the list of software tools required to run a project.

```
* Git
* JDK 8 or later
* Gradle 6.0 or later
```

### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/centimetech/service-template.git
cd service-template
```

### Configuration
In order to get your service working you have to make below modifications:
```
service-template = "Your Application Name" In bootstrap.properties & settings.gradle

```

## Build
Build the spring boot application

```
gradle clean --refresh-dependencies
gradle clean test bootJar

```

## Scan
Scan the spring boot application

```
gradle sonarQube
```

## Deploy

```
gradle  bootRun
```

### Health Check of Application

```
curl "http://localhost:8080/actuator/health"
```
will give a response if success
```
{
    "status":"UP"
}
```

### Test

Test microservice using below tool.

* Postman
* Swagger Endpoint : http://localhost:8080/swagger-ui.html


## Deployment

Add additional notes about how to deploy this on a live system

## Reference 

* [Create GIT Repository](https://centime.atlassian.net/wiki/spaces/CETD/pages/54525961/Create+GIT+Repository)
* [Centime Logger Usage](https://centime.atlassian.net/wiki/spaces/CETD/pages/9601156/Centime+Logging+Library)
* [Connect To Centime Spring Config Server](https://centime.atlassian.net/wiki/spaces/CETD/pages/54722569/Centime+Spring+Cloud+Config+Server)
* [Create Custom Error File](https://centime.atlassian.net/wiki/spaces/CETD/pages/10256547/Centime+Error+Handling)
* [Customize Docker Image](https://centime.atlassian.net/wiki/spaces/CETD/pages/53936202/Docker+Configuration)
* [Customize Kubernetes Deployment](https://centime.atlassian.net/wiki/spaces/CETD/pages/53936149/Kubernetes+Configuration)
* [Create Jenkins Job](https://centime.atlassian.net/wiki/spaces/CETD/pages/53936243/Jenkins+Configuration)
* [Build & Deploy Centime Microservice](https://centime.atlassian.net/wiki/spaces/CETD/pages/54689803/Build%2BDeploy%2BCentime%2BMicroservice)

## Authors

* **Rahul Bajaj**
* **Aakash Kedia**

See also the list of [contributors](https://github.com/centimetech/service-template/graphs/contributors) who participated in this project.



