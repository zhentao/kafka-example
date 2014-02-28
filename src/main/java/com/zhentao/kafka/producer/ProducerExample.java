package com.zhentao.kafka.producer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.zhentao.kafka.Constants;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class ProducerExample {
    public static void main(String[] args) {
        long events = 10;
        Random rnd = new Random();

        Properties props = new Properties();
        //props.put("metadata.broker.list", "localhost:9092,localhost:9093");
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", StringEncoder.class.getName());
        props.put("partitioner.class", SimplePartitioner.class.getName());
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);

        for (long nEvents = 0; nEvents < events; nEvents++) {
               long runtime = new Date().getTime();
               String ip = "192.168.2." + rnd.nextInt(255);
               String msg = runtime + ", www.example.com, " + ip;
               KeyedMessage<String, String> data = new KeyedMessage<String, String>(Constants.TOPIC, ip, msg);
               producer.send(data);
        }
        producer.close();
    }
}