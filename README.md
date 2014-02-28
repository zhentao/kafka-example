An example to show how to use maven to manage Kafka dependencies. Reuse the consumer and produser code from kafka.apache.com.
1. kafka 0.8 release
2. scala 2.10

cp src/main/config/server* to kafka/config

start zookeeper:

bin/zookeeper-server-start.sh config/zookeeper.properties

start Kafka server:

bin/kafka-server-start.sh config/server.properties

Run Producer first

mvn exec:java -Dexec.mainClass="com.zhentao.kafka.producer.ProducerExample"

Run consumer:
mvn exec:java -Dexec.mainClass="com.zhentao.kafka.consumer.ConsumerGroupExample"
