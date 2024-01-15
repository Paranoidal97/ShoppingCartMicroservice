FROM eclipse-temurin:17-jdk-alpine
COPY target/ShoppingCartMicroservice-0.0.1-SNAPSHOT.jar ShoppingCartMicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ShoppingCartMicroservice-0.0.1-SNAPSHOT.jar"]