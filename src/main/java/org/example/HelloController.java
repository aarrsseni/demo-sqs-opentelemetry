package org.example;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @Autowired
    private SqsTemplate sqsTemplate;

    @GetMapping("/")
    public String index() {
        logger.info("Sending sqs.");
        sqsTemplate.send("test-queue", "1");
        return "Sent";
    }

}