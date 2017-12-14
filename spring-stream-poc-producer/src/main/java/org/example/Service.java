package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;

public class Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    private Producer producer;

    private Random random = new Random();

    public Service(Producer producer) {
        this.producer = producer;
    }

    public void sendMessages() throws InterruptedException {
        int numberMessages = random.nextInt(5);
        for (int i = 0; i < numberMessages; i++) {
            Thread.sleep(random.nextInt(1000));
            Message message = new Message(numberMessages + "", "Message " + i + " from producer " + LocalDateTime.now());
            LOGGER.info(message.toString());
            producer.send(message);
        }
    }

}
