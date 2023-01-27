# order-service
Order taking microservice

### Configuration
Uses configuration server at http://localhost:8888 by default.
Does not start without configuration server.
Configurable at resources/application.properties.
Check for its config with http://localhost:8888/order-service/default

### Build
mvn clean install

### Run
java -jar target/order-service-0.0.1-SNAPSHOT.jar

Note:
Tested locally with "java 18.0.2 2022-07-19"

### Test
http://localhost:8080/orders/status
