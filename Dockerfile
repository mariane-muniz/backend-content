FROM openjdk:8-jdk
ADD target/content.jar content.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "content.jar" ]