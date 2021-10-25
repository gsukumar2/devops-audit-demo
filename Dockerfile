FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/devops-audit-demo.jar devops-audit-demo.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/devops-audit-demo.jar"]
