FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-cloud-config.jar
ENTRYPOINT ["java","-jar","/ims-cloud-config.jar"]
EXPOSE 9296