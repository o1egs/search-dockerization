# FROM openjdk:20
# ADD /target/SearchService-0.0.1-SNAPSHOT.jar /backend.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar", "backend.jar"]

FROM maven:3.6.3-openjdk-17
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=true
CMD ["java", "-jar", "target/SearchService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
