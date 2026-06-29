package io.cloudmonitor.platform.producer;

import io.cloudmonitor.platform.model.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProducer {

    private static final Logger logger =
            LoggerFactory.getLogger(TelemetryProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TelemetryProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTelemetry(TelemetryEvent event) {

        logger.info("Publishing telemetry event {} from host {}",
                event.getEventId(),
                event.getHostName());

        kafkaTemplate.send("telemetry.raw", event);
    }
}