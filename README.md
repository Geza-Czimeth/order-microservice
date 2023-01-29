# Melita's Order Taking microservice

### Configuration

Uses configuration server at http://localhost:8888 by default.
Does not start without configuration server.
Configurable at resources/application.properties.
Check for its config with http://localhost:8888/order-service/default

### RabbitMQ setup with docker
<pre>
The following docker command used to start rabbitmq.

docker pull rabbitmq:3.9.27-management
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.9.27-management

Management interface: http://localhost:15672/

username: guest
password: guest
</pre>
### Build

mvn clean install

### Run

java -jar target/order-service-0.0.1-SNAPSHOT.jar

Note:
Tested locally with "java 18.0.2 2022-07-19"

### Run from Ide
Main class is OrderServiceApplication.
Just run it as it is.

### Integration Test with postman

Postman version used: v10.6.0
File name for requests "Melita Order Service Integration tests.postman_collection.json"
