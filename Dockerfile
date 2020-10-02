FROM openjdk:11.0.5-jdk
MAINTAINER Sarpe Marius <sarpe36@gmail.com>
RUN apt-get -y update
RUN apt-get -y upgrade
RUN apt-get install -y sqlite3 libsqlite3-dev
COPY ./target/Interview-Task-1.0-SNAPSHOT-jar-with-dependencies.jar /app/
ENTRYPOINT ["java", "-jar", "/app/Interview-Task-1.0-SNAPSHOT-jar-with-dependencies.jar"]




