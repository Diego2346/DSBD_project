FROM maven:3-jdk-11 as builder
WORKDIR /project
COPY API_gateway/ API_gateway
WORKDIR /project/API_gateway
RUN mvn install
WORKDIR /project
COPY API_gateway .
RUN mvn package

FROM openjdk:15-alpine
WORKDIR /app
COPY --from=builder /project/target/API_gateway-0.0.1-SNAPSHOT.jar ./API_gateway.jar
CMD java -jar API_gateway.jar