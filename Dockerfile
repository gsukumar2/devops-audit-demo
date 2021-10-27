FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/devops-audit-demo.jar devops-audit-demo.jar
COPY src/main/resources/templates/index.html index.html
EXPOSE 8089
ENTRYPOINT ["java","-jar","/devops-audit-demo.jar"]
