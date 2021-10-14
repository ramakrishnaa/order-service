FROM openjdk:11
ADD target/order-service.jar docker-order-service.jar
EXPOSE 7070
ENTRYPOINT ["java","-jar", "docker-order-service.jar"]