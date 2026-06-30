package io.cloudmonitor.platform.router;

import io.cloudmonitor.platform.config.KafkaTopics;
import io.cloudmonitor.platform.model.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryRouter {

    private static final Logger logger =
            LoggerFactory.getLogger(TelemetryRouter.class);

    private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;

    public TelemetryRouter(KafkaTemplate<String, TelemetryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Routes telemetry events to downstream topics based on
     * resource utilization thresholds.
     */
    @KafkaListener(topics = KafkaTopics.RAW, groupId = "telemetry-router")
    public void route(TelemetryEvent event) {

        System.out.println("=================================");
        System.out.println("ROUTER RECEIVED EVENT");
        System.out.println(event);
        System.out.println("=================================");

        logger.info("Routing telemetry event {}", event.getEventId());

        kafkaTemplate.send(KafkaTopics.STORAGE, event);

        if (event.getCpuUsage() > 90 || event.getMemoryUsage() > 90) {

            logger.warn("High resource usage detected on {}", event.getHostName());

            kafkaTemplate.send(KafkaTopics.ALERT, event);
        }
    }
}