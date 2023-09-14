FROM gradle:7.6.1-jdk11-alpine

COPY . .

EXPOSE 8080

RUN gradle build

ENTRYPOINT ["java", "-jar", "homebanking-0.0.1-SNAPSHOT.jar"]