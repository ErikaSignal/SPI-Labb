FROM eclipse-temurin:22-jre-alpine
COPY service/target/service-1.0-SNAPSHOT.jar /service.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar /provider.jar
COPY consumer/target/consumer-1.0-SNAPSHOT.jar /consumer.jar
CMD ["java", "--module-path", "/service.jar:/provider.jar:/consumer.jar", "-m", "org.example.consumer/org.example.consumer.Main"]