package io.cloudmonitor.platform.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic telemetryRawTopic() {
        return new NewTopic("telemetry.raw", 3, (short) 1);
    }

    @Bean
    public NewTopic telemetryStorageTopic() {
        return new NewTopic("telemetry.storage", 3, (short) 1);
    }

    @Bean
    public NewTopic telemetryAlertTopic() {
        return new NewTopic("telemetry.alert", 3, (short) 1);
    }

}