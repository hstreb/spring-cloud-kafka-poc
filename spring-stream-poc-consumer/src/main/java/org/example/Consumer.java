package org.example;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(value={Topic.class})
public class Consumer {

    private Service service;

    public Consumer(Service service) {
        this.service = service;
    }

    @ServiceActivator(inputChannel = Topic.INPUT_TOPIC)
    public void consume(String message) {
        try {
            service.consume(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
