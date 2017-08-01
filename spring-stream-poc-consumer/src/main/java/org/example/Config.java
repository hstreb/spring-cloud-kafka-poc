package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Config {

    @Autowired
    private Topic topic;

    private Random random = new Random();

    @Bean
    Service service() {
        return new Service();
    }

    @Bean
    Consumer producer() {
        return new Consumer(service());
    }
}
