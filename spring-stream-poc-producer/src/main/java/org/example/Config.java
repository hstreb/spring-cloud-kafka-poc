package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@Configuration
@EnableScheduling
public class Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    @Autowired
    private Topic topic;

    private Random random = new Random();

    Producer producer() {
        return new Producer(topic);
    }

    Service service() {
        return new Service(producer());
    }

    @Scheduled(fixedRate = 6000)
    public void keepAlive() throws InterruptedException {
        service().sendMessages();
    }
}
