FROM openjdk:20
ADD /target/SearchService-0.0.1-SNAPSHOT.jar /backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "backend.jar"]
