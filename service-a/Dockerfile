FROM maven:3.8.4-openjdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml package

FROM payara/server-full:5.201
COPY --from=build /home/app/target/samplemicroprofile.war $DEPLOY_DIR