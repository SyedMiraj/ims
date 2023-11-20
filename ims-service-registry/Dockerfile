FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-service-registry.jar
ENTRYPOINT ["java","-jar","/ims-service-registry.jar"]
EXPOSE 8761