FROM java:8-jdk-alpine

COPY build/libs/*.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch performance_indicator_service.jar'

ENTRYPOINT ["java","-jar","performance_indicator_service.jar","--server.port=9093"]

EXPOSE 9093

//docker file needs to be updated
//Change jar name,port as per service port mapping
