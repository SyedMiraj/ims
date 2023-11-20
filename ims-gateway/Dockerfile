FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-gateway.jar
ENTRYPOINT ["java","-jar","/ims-gateway.jar"]
EXPOSE 8080