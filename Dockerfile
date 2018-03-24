FROM maven:3.5.3-jdk-8

COPY . /home/league-manager-api/

WORKDIR /home/league-manager-api

CMD mvn install && mvn spring-boot:run