FROM openjdk:8-jre-alpine

ARG SERVICE_NAME
ARG PORT_NUMBER

COPY build/libs/*.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch $SERVICE_NAME.jar'

ENTRYPOINT ["java","-jar","$SERVICE_NAME.jar","--server.port=$PORT_NUMBER"]

EXPOSE $PORT_NUMBER
