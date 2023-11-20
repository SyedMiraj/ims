FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-user-service.jar
ENTRYPOINT ["java","-jar","/ims-user-service.jar"]
EXPOSE 9004