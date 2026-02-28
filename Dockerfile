FROM openjdk:25-ea-1-jdk
WORKDIR /app
COPY target/currency_converter-0.0.1-SNAPSHOT.jar /app/currency-converter.jar
EXPOSE 8080
CMD [ "java", "-jar", "currency-converter.jar" ]