package io.cloudmonitor.platform.service;

import io.cloudmonitor.platform.model.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    private static final Logger logger =
            LoggerFactory.getLogger(AlertService.class);

    public void generateAlert(TelemetryEvent event) {

        logger.warn("""
                
                ================= ALERT =================
                Host            : {}
                Region          : {}
                CPU Usage       : {}%
                Memory Usage    : {}%
                Disk Usage      : {}%
                Network         : {} Mbps
                Timestamp       : {}
                =========================================
                """,
                event.getHostName(),
                event.getRegion(),
                event.getCpuUsage(),
                event.getMemoryUsage(),
                event.getDiskUsage(),
                event.getNetworkThroughput(),
                event.getTimestamp());
    }
}