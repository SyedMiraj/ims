# Stage one
FROM maven:3.6.3-adoptopenjdk-11 as stage1
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

# Stage two
FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
ARG JAR_FILE=target/*.jar
COPY --from=stage1 /build/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9004