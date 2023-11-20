FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ims-product-service.jar
ENTRYPOINT ["java","-jar","/ims-product-service.jar"]
EXPOSE 9002