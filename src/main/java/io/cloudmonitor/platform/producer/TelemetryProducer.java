package io.cloudmonitor.platform.producer;

import io.cloudmonitor.platform.config.KafkaTopics;
import io.cloudmonitor.platform.model.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProducer {

    private static final Logger logger =
            LoggerFactory.getLogger(TelemetryProducer.class);

    private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;

    public TelemetryProducer(KafkaTemplate<String, TelemetryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    /**
     * Publishes incoming telemetry events to the raw Kafka topic.
     * This acts as the entry point into the event processing pipeline.
     */
    public void publishTelemetry(TelemetryEvent event) {

        logger.info("Publishing telemetry event {} from host {}",
                event.getEventId(),
                event.getHostName());

        System.out.println("PRODUCER HIT");

        kafkaTemplate.send(KafkaTopics.RAW, event)
                .whenComplete((result, ex) -> {

                    if (ex == null) {
                        System.out.println("MESSAGE SENT SUCCESSFULLY");
                    } else {
                        ex.printStackTrace();
                    }

                });
    }
}