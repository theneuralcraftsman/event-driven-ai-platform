package io.cloudmonitor.platform.consumer;

import io.cloudmonitor.platform.config.KafkaTopics;
import io.cloudmonitor.platform.model.TelemetryEvent;
import io.cloudmonitor.platform.service.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AlertConsumer {

    private static final Logger logger =
            LoggerFactory.getLogger(AlertConsumer.class);

    private final AlertService alertService;

    public AlertConsumer(AlertService alertService) {
        this.alertService = alertService;
    }

    @KafkaListener(
            topics = KafkaTopics.ALERT,
            groupId = "telemetry-alert")
    public void consume(TelemetryEvent event) {

        logger.info(
                "Alert event received for host {}",
                event.getHostName());

        alertService.generateAlert(event);
    }
}