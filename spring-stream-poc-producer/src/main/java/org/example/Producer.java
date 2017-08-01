package org.example;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(value={Topic.class})
public class Producer {

    private Topic topic;

    public Producer(Topic topic) {
        this.topic = topic;
    }

    public void send(String message) {
        topic.send().send(MessageBuilder.withPayload(message).build());
    }

}
