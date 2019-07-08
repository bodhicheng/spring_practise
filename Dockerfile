FROM repository.gridsum.com:8443/maven:3.5.2 AS build
COPY . /usr/src/java-demo
RUN mvn -f /usr/src/java-demo/pom.xml clean package
FROM repository.gridsum.com:8443/openjdk:8
COPY --from=build /usr/src/java-demo/target/spring_practise-1.0-SNAPSHOT.war /usr/java-demo/app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]