package com.zhentao.kafka.consumer;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerRunnable implements Runnable {
    private final KafkaStream<byte[], byte[]> stream;
    private final int threadNumber;

    public ConsumerRunnable(KafkaStream<byte[], byte[]> a_stream, int a_threadNumber) {
        threadNumber = a_threadNumber;
        stream = a_stream;
    }

    @Override
    public void run() {

        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            System.out.println("Thread " + threadNumber + ": " + new String(it.next().message()));
        }

        System.out.println("Shutting down Thread: " + threadNumber);
    }
}
