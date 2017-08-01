package org.example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Topic {

    String OUTPUT_TOPIC = "topic_out";

    @Output(OUTPUT_TOPIC)
    MessageChannel send();

}
