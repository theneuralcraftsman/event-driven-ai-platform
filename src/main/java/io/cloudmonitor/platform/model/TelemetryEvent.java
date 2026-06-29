package io.cloudmonitor.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelemetryEvent {

    // Unique event identifier
    private String eventId;

    // Server generating the metric
    private String hostName;

    // Cloud region
    private String region;

    // Resource utilization (%)
    private double cpuUsage;
    private double memoryUsage;
    private double diskUsage;

    // Network throughput (Mbps)
    private double networkThroughput;

    // Time at which telemetry was generated
    private LocalDateTime timestamp;
}