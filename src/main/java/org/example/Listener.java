package org.example;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    private static final Logger logger = LogManager.getLogger(Listener.class);
    @SqsListener("test-queue")
    public void receiveStringMessage(String test) {
        logger.info(test);
    }
}
