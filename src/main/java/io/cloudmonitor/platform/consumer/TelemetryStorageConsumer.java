package io.cloudmonitor.platform.consumer;

import io.cloudmonitor.platform.config.KafkaTopics;
import io.cloudmonitor.platform.model.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TelemetryStorageConsumer {

    private static final Logger logger =
            LoggerFactory.getLogger(TelemetryStorageConsumer.class);

    @KafkaListener(
            topics = KafkaTopics.STORAGE,
            groupId = "telemetry-storage")
    public void consume(TelemetryEvent event) {

        logger.info(
                "Storing telemetry event {} from host {}",
                event.getEventId(),
                event.getHostName());

        // Database persistence will be implemented in Phase 3.
    }
}