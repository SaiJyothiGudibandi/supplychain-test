FROM sbo-cicd-docker-release-local.artifactory-lvn.broadcom.net/broadcom-custom-images/centos/8/mvn:latest
# COPY target/*.jar MavenHelloWorld-SNAPSHOT.jar
# ENTRYPOINT ["sh", "-c", "java -jar /MavenHelloWorld-SNAPSHOT.jar"]
CMD ["echo", "Hello World!!-test2"]
