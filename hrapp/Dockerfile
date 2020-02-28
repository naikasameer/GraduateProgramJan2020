FROM openjdk:8-jdk-alpine
WORKDIR /hrapp
COPY ./target/*.jar /hrapp 
CMD DIR /S
ENTRYPOINT ["java","-jar","hrapp-0.0.1-SNAPSHOT.jar"]
EXPOSE 7777