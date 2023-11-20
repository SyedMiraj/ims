FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-customer-service.jar
ENTRYPOINT ["java","-jar","/ims-customer-service.jar"]
EXPOSE 9001