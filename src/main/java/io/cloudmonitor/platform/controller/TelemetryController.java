package io.cloudmonitor.platform.controller;

import io.cloudmonitor.platform.model.TelemetryEvent;
import io.cloudmonitor.platform.producer.TelemetryProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController {

    private final TelemetryProducer telemetryProducer;

    public TelemetryController(TelemetryProducer telemetryProducer) {
        this.telemetryProducer = telemetryProducer;
    }

    @PostMapping
    public ResponseEntity<String> ingestTelemetry(@RequestBody TelemetryEvent telemetryEvent) {

        telemetryProducer.publishTelemetry(telemetryEvent);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Telemetry event published successfully.");
    }
}