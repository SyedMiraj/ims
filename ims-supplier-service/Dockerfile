FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-supplier-service.jar
ENTRYPOINT ["java","-jar","/ims-supplier-service.jar"]
EXPOSE 9003