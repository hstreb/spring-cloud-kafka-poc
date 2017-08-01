package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    public void consume(String message) throws InterruptedException {
        LOGGER.info("message received '{}'", message);
    }

}
