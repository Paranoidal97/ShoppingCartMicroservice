FROM eclipse-temurin:17-jdk-alpine
COPY /ShoppingCartMicroservice/target/shopping-cart-microservice-0.0.1-SNAPSHOT.jar shopping-cart-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shopping-cart-microservice-0.0.1-SNAPSHOT.jar"]