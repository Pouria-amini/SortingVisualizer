FROM openjdk:8-jre-alpine
COPY target/Task-1.0-SNAPSHOT.jar /SortingVitualizer.war
CMD ["/usr/bin/java", "-jar", "/SortingVitualizer.war"]