FROM maven:3-jdk-11 as builder
WORKDIR /project
COPY event/ event
WORKDIR /project/event
RUN mvn install
WORKDIR /project
COPY event .
RUN mvn package

FROM openjdk:15-alpine
WORKDIR /app
COPY --from=builder /project/target/event-0.0.1-SNAPSHOT.jar ./event.jar
CMD java -jar event.jar