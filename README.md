# kafka-studies
Simple project to validate kafka solution and learn about easily and difficulties in development mode.

firstly, start service with this command:
 . docker-compose up -d

second, start the producer with this command:
 . mvn compule quarkus:dev
 
third, start the consumer with this command:
 . mvn compule quarkus:dev
 
Now you can access <a href="http://localhost:19000">kafdrop</a>

The producer will create random numbers and send to kafta on the topic "prices", in the same way, the consumer will get access to theses values and show up in your console, simple as you are seeing!
