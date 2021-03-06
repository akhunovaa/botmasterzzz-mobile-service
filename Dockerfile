FROM openjdk:8-jre-alpine
COPY . /app
WORKDIR /app
CMD java -Dspring.profiles.active=dev -agentlib:jdwp=transport=dt_socket,address=20016,suspend=n,server=y -jar target/*-SNAPSHOT.jar