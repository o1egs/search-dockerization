# FROM openjdk:20
# ADD /target/SearchService-0.0.1-SNAPSHOT.jar /backend.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar", "backend.jar"]

#FROM maven:3.6.3-openjdk-17
#COPY ./ ./
#RUN mvn clean package -Dmaven.test.skip=true
#CMD ["java", "-jar", "target/SearchService-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080
FROM maven:latest AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/SearchService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]