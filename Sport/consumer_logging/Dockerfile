FROM maven:3-jdk-11 as builder
WORKDIR /project
COPY consumer_logging/ consumer_logging
WORKDIR /project/consumer_logging
RUN mvn install
WORKDIR /project
COPY consumer_logging .
RUN mvn package

FROM openjdk:15-alpine
WORKDIR /app
COPY --from=builder /project/target/consumer_logging-0.0.1-SNAPSHOT.jar ./consumer_logging.jar
CMD java -jar consumer_logging.jar