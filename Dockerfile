FROM openjdk:17
LABEL authors="ohf"

ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 9091
ENTRYPOINT ["java","-jar","/app.jar"]