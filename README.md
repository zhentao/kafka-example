An example to show how to use maven to manage Kafka dependencies. Reuse the [consumer](https://cwiki.apache.org/confluence/display/KAFKA/Consumer+Group+Example) and [produser](https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example) code.

1. kafka 0.8 release
2. scala 2.10
3. cp src/main/config/server* to kafka/config

start zookeeper:
----------------
	bin/zookeeper-server-start.sh config/zookeeper.properties

start Kafka server:
-------------------
	bin/kafka-server-start.sh config/server.properties

Run Producer
------------
	mvn exec:java -Dexec.mainClass="com.zhentao.kafka.producer.ProducerExample"

Run consumer:
-------------
	mvn exec:java -Dexec.mainClass="com.zhentao.kafka.consumer.ConsumerGroupExample"
