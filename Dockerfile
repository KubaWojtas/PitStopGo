FROM openjdk:21-jdk
ADD target/VroomVroom.jar VroomVroom.jar
ENTRYPOINT ["java", "-jar", "/VroomVroom.jar"]